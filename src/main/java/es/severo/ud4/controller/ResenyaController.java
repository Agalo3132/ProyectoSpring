package es.severo.ud4.controller;

import es.severo.ud4.entity.Resenya;
import es.severo.ud4.repository.PeliculaRepository;
import es.severo.ud4.repository.ResenyaRepository;
import es.severo.ud4.service.PeliculaService;
import es.severo.ud4.service.ResenyaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ResenyaController {


    private final ResenyaService resenyaService;
    private final ResenyaRepository resenyaRepository;


    public ResenyaController(ResenyaService resenyaService, ResenyaRepository resenyaRepository) {
        this.resenyaService = resenyaService;
        this.resenyaRepository = resenyaRepository;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }


    @GetMapping("/resenyas")
    public String getResenyas(Model model) {
        model.addAttribute("resenyas", resenyaService.findAll());
        return "resenya/resenyas";
    }

    @GetMapping("resenya/create")
    public String addNewResenya(Model model) {
        model.addAttribute("r", new Resenya());
        return "resenya/add";
    }

    @PostMapping("/add")
    public String saveResenya(@ModelAttribute("t") Resenya resenya) {
        resenyaService.create(resenya);
        return "redirect:/view/resenyas";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Resenya resenya = resenyaService.findById(id);
        model.addAttribute("resenya", resenya);
        return "resenya/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        resenyaService.delete(id);
        return "redirect:/view/resenyas";
    }


}
