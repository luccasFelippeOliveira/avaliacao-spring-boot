package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    EstudanteService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("estudantes", service.buscarEstudantes());
        return "index";
    }
}
