package com.mkaminski.hermes.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkaminski.hermes.configuration.SecurityConfiguration;
import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.service.CourierService;
import com.mkaminski.hermes.service.EmailService;



@Controller
public class MainController {

    @Autowired
    private CourierService courierService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Courier courier) {


        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(SecurityConfiguration.PASSWORD_STRENGHT);
            String encodedPassword = encoder.encode(courier.getPassword());
            courier.setPassword(encodedPassword);
            courierService.save(courier);

        } catch (Exception e) {

            return "redirect:/register";
        }
                  
        emailService.sendEmail("hermes.delivery.noreply@gmail.com", courier.getEmail(), "Welcome in our couriers service management",
        		"Welcome " + courier.getFirstName() + " " + courier.getLastName() );

        return "redirect:/login";	
    }
        


}
