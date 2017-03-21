package com.mkaminski.hermes.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.service.CourierService;

@Controller
public class CourierController {

    @Autowired
    private CourierService courierService;


    @RequestMapping(value = "/couriers", method = RequestMethod.GET)
    public String getCouriersPage(Model model) {

        List<Courier> couriers = courierService.findAll();

        model.addAttribute("couriersList", couriers);

        return "couriers";
    }

    @RequestMapping(value = "/create-courier", method = RequestMethod.GET)
    public String getCourierForm() {
        return "courier-create";
    }

    @RequestMapping(value = "/create-courier", method = RequestMethod.POST)
    public String saveCourier(@RequestParam(required = false) Long id,
                           @RequestParam(name = "firstName", required = true) String firstName,
                           @RequestParam String lastName,
                           @RequestParam (required = true) String email,
                           @RequestParam (required = true) String password) {

        Courier courier = new Courier(firstName, lastName, email, password);
        courier.setId(id);

        courierService.save(courier);

        return "redirect:/couriers";
    }


    @RequestMapping(value = "/couriers/delete/{id}", method = RequestMethod.POST)
    public String deleteCourier(@PathVariable Long id) {

    	courierService.delete(id);

        return "redirect:/couriers";
    }


    @RequestMapping(value = "/couriers/edit/{id}", method = RequestMethod.GET)
    public String getCourierEditPage(@PathVariable Long id, Model model) {

        Courier courier = courierService.findOne(id);

        model.addAttribute("courier", courier);

        return "courier-create";
    }
    
    
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String getCourierAccount(Model model, Principal principal) {
    	  String email = principal.getName();
    	  
    	Courier courier = courierService.findByEmail(email);
    	
    	model.addAttribute("courier",courier);
   	
        return "courier-create";
    }
    
    
    
   
    
    


}
