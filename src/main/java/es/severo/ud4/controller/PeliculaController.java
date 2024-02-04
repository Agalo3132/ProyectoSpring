package es.severo.ud4.controller;


import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.repository.PeliculaRepository;
import es.severo.ud4.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/view")
public class PeliculaController {

    private final PeliculaService peliculaService;
    private final PeliculaRepository peliculaRepository;


    public PeliculaController(PeliculaService peliculaService, PeliculaRepository peliculaRepository) {
        this.peliculaService = peliculaService;
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }


    @GetMapping("/peliculas")
    public String getPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.findAll());
        return "pelicula/peliculas";
    }

    @GetMapping("pelicula/create")
    public String addNewPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "pelicula/add";
    }


    @PostMapping("/add")
    public String savePelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
        peliculaService.create(pelicula);
        return "redirect:/view/peliculas";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Pelicula pelicula = peliculaService.findById(id);
        model.addAttribute("pelicula", pelicula);
        return "pelicula/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        peliculaService.delete(id);
        return "redirect:/view/peliculas";
    }

    


}
