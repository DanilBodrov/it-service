package ru.itService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itService.model.MagicSquare;
import ru.itService.service.MagicSquareService;

@Controller
public class MagicSquareController {

    private final MagicSquareService magicSquareService;

    public MagicSquareController(MagicSquareService magicSquareService) {
        this.magicSquareService = magicSquareService;
    }

    /*@GetMapping("/magicCalculation")
    public String magicCalculation() {
        return "magicCalculation";
    }*/

    @GetMapping("/registerPage")
    public String registerPage(Model model, @RequestParam(name = "validate", required = false) Boolean validate) {
        model.addAttribute("validate", validate != null);
        return "magicCalculation";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute MagicSquare magicSquare) {
        boolean validate = magicSquareService.validateMagicSquare(magicSquare);
        if (validate) {
            return "redirect:/registerPage?validate=false";
        }
        magicSquareService.magicCalculate(magicSquare);
        magicSquareService.create(magicSquare);
        return "redirect:/registerPage";
    }

    @PostMapping("/exportMagicToTxt")
    public String exportMagicToTxt(@ModelAttribute MagicSquare magicSquare) {
        boolean validate = magicSquareService.validateMagicSquare(magicSquare);
        if (validate) {
            return "redirect:/registerPage?validate=false";
        }
        magicSquareService.exportInTxt(magicSquare);
        return "redirect:/registerPage";
    }
}
