package es.severo.ud4.controller;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.repository.DirectorRepository;
import es.severo.ud4.repository.PeliculaRepository;
import es.severo.ud4.service.DirectorService;
import es.severo.ud4.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("/view")
public class DirectorController {


    private final DirectorService directorService;
    private final DirectorRepository directorRepository;


    public DirectorController(DirectorService directorService, DirectorRepository directorRepository) {
        this.directorService = directorService;
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }


    @GetMapping("/directores")
    public String getDirectores(Model model) {
        model.addAttribute("directores", directorService.findAll());
        return "director/directores";
    }

    @GetMapping("director/create")
    public String addNewDirector(Model model) {
        model.addAttribute("director", new Director());
        return "director/add";
    }


    @PostMapping("/add")
    public String saveDirector(@ModelAttribute("director") Director director) {
        directorService.create(director);
        return "redirect:/view/director";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Director director = directorService.findById(id);
        model.addAttribute("director", director);
        return "director/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        directorService.delete(id);
        return "redirect:/view/directores";
    }

}
