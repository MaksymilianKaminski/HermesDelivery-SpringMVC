package com.mkaminski.hermes.controller;

import com.mkaminski.hermes.model.Package;
import com.mkaminski.hermes.service.PackageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class PackageController {
    
   @Autowired
   private PackageService  packageService;

    @RequestMapping(value = "/packs", method = RequestMethod.GET)
    public String getPacksPage(Model model) {

        List<Package> packList = packageService.findAll();

        model.addAttribute("packList", packList);

        return "packs";
    }

    @RequestMapping(value = "/pack/create", method = RequestMethod.GET)
    public String getCreatePackForm(Model model) {

        model.addAttribute("pack", new Package());

        return "pack-create";
    }

    @RequestMapping(value = "/pack/edit/{id}", method = RequestMethod.GET)
    public String getEditPackForm(Model model, @PathVariable Long id) {

        Package pack = packageService.findOne(id);

        model.addAttribute("pack", pack);

        return "pack-create"; 
    }

    @RequestMapping(value = "/pack/save", method = RequestMethod.POST)
    public String postCreatePack(@ModelAttribute @Valid Package pack, BindingResult result) {

        if (result.hasErrors()) {
            return "pack-create";
        }

        packageService.save(pack);

        return "redirect:/packs"; 
    }

    @RequestMapping(value = "/pack/delete/{id}", method = RequestMethod.POST)
    public String postDeletePack(@PathVariable Long id) {

    	packageService.delete(id);

        return "redirect:/packs";  
    }

    
}
