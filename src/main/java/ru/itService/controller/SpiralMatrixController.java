package ru.itService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itService.service.SpiralMatrixService;

@Controller
public class SpiralMatrixController {

    private final SpiralMatrixService service;

    public SpiralMatrixController(SpiralMatrixService service) {
        this.service = service;
    }

    @GetMapping("/spiralMatrix")
    public String spiralMatrix(Model model) {
        model.addAttribute("matrix", service.calculationSpiralMatrix(2));
        return "spiralMatrix";
    }

    @GetMapping("/calculationSpiralMatrix")
    public String calculateM(Model model, @RequestParam("number") int number) {
        model.addAttribute("matrix", service.calculationSpiralMatrix(number));
        return "spiralMatrix";
    }

}
