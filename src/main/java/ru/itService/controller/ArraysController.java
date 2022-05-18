package ru.itService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itService.model.ArrayStrings;
import ru.itService.service.ArraysService;

import java.util.List;

@Controller
public class ArraysController {

    private final ArraysService arraysService;

    public ArraysController(ArraysService arraysService) {
        this.arraysService = arraysService;
    }

    @GetMapping("/arraysCalculation")
    public String calculation() {
        return "arraysCalculation";
    }

    @PostMapping("/addArrayStrings")
    public String addArrayStrings(@ModelAttribute ArrayStrings arrayStrings) {
        arraysService.create(arrayStrings);
        return "redirect:/arraysCalculation";
    }

    @GetMapping("/findArrayStrings")
    public String findArrayStrings(Model model) {
        model.addAttribute("arraysString", arraysService.findAll());
        return "findArrayStrings";
    }

    @GetMapping("/findByCount")
    public String findByCount(Model model, @RequestParam("count") int count) {
        model.addAttribute("arraysString", arraysService.findByCount(count));
        return "findArrayStrings";
    }

    @PostMapping("/exportArrayToTxt")
    public String exportArrayToTxt(@ModelAttribute ArrayStrings arrayStrings) {
        arraysService.exportArrayToTxt(arrayStrings);
        return "redirect:/arraysCalculation";
    }

    @PostMapping("/importArrayFromTxt")
    public String importArrayFromTxt(@RequestParam("file") MultipartFile file) {
        List<ArrayStrings> list = arraysService.importArrayFromTxt(file);
        arraysService.createAll(list);
        return "redirect:/arraysCalculation";
    }
}
