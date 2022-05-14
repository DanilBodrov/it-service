package ru.itService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itService.model.ArrayStrings;
import ru.itService.service.ArraysService;

import java.io.File;
import java.util.List;

@Controller
public class ArraysController {

    private  final ArraysService arraysService;

    public ArraysController(ArraysService arraysService) {
        this.arraysService = arraysService;
    }

    @GetMapping("/calculation")
    public String calculation() {
        return "calculation";
    }

    @PostMapping("/addToDb")
    public String addToDb(@ModelAttribute ArrayStrings arrayStrings) {
        arraysService.create(arrayStrings);
        return "redirect:/calculation";
    }

    @GetMapping("/allBySubstringType")
    public String allArraysString(Model model) {
        model.addAttribute("arraysString", arraysService.findAll());
        return "allBySubstringType";
    }

    @GetMapping("/findByCount")
    public String findByCount(Model model, @RequestParam("count") int count) {
        model.addAttribute("arraysString", arraysService.findByCount(count));
        return "allBySubstringType";
    }

    @PostMapping("/exportToTxt")
    public String exportInTxt(@ModelAttribute ArrayStrings arrayStrings) {
        arraysService.exportInTxt(arrayStrings);
        return "redirect:/calculation";
    }

    @PostMapping("/importFromTxt")
    public String importFromTxt(@RequestParam("file") MultipartFile file) {
        List<ArrayStrings> list = arraysService.importFromTxt(file);
        arraysService.createAll(list);
        return "redirect:/calculation";
    }

}
