package ru.itService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itService.model.MagicSquare;
import ru.itService.service.MagicSquareResultService;
import ru.itService.service.MagicSquareService;

import java.util.List;

@Controller
public class MagicSquareController {

    private final MagicSquareService magicSquareService;
    private final MagicSquareResultService magicSquareResultService;

    public MagicSquareController(MagicSquareService magicSquareService,
                                 MagicSquareResultService magicSquareResultService) {
        this.magicSquareService = magicSquareService;
        this.magicSquareResultService = magicSquareResultService;
    }

    @GetMapping("/magicCalculation")
    public String magicCalculation(Model model, @RequestParam(name = "validate", required = false) Boolean validate) {
        model.addAttribute("validate", validate != null);
        return "magicCalculation";
    }

    @PostMapping("/addMagicSquare")
    public String addMagicSquare(@ModelAttribute MagicSquare magicSquare) {
        boolean validate = magicSquareService.validateMagicSquare(magicSquare);
        if (validate) {
            return "redirect:/magicCalculation?validate=false";
        }
        magicSquareService.create(magicSquare);
        magicSquareResultService.create(magicSquare);
        return "redirect:/magicCalculation";
    }

    @GetMapping("/findMagicSquare")
    public String findMagicSquare(Model model) {
        model.addAttribute("magicSquares", magicSquareResultService.findAll());
        return "findMagicSquare";
    }

    @PostMapping("/exportMagicToTxt")
    public String exportMagicToTxt(@ModelAttribute MagicSquare magicSquare) {
        boolean validate = magicSquareService.validateMagicSquare(magicSquare);
        if (validate) {
            return "redirect:/magicCalculation?validate=false";
        }
        magicSquareService.exportInTxt(magicSquare);
        return "redirect:/magicCalculation";
    }

    @PostMapping("/importMagicSquareFromTxt")
    public String importMagicSquareFromTxt(@RequestParam("file") MultipartFile file) {
        List<MagicSquare> list = magicSquareService.importFromTxt(file);
        magicSquareService.createAll(list);
        magicSquareResultService.createAll(list);
        return "redirect:/magicCalculation";
    }
}
