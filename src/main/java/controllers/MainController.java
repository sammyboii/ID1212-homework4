package controllers;

import dto.ConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ConversionManager;

import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private ConversionManager conversionManager;

    @GetMapping("/")
    public String index(Model model) {
        prepareFormEssentials(model);
        model.addAttribute("dto", new ConversionDTO());
        return "conversion_form";
    }

    @PostMapping("/")
    public String convert(@ModelAttribute ConversionDTO request, Model model) {
        String result = conversionManager.convert(request);
        model.addAttribute("result", result);
        model.addAttribute("dto", request);
        prepareFormEssentials(model);
        return "conversion_form";
    }

    private void prepareFormEssentials(Model model) {
        Set<String> fromCurrencies = conversionManager.getFromCurrencies();
        Set<String> toCurrencies = conversionManager.getToCurrencies();
        model.addAttribute("fromCurrencies", fromCurrencies);
        model.addAttribute("toCurrencies", toCurrencies);
    }
}
