package com.mkaminski.hermes.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkaminski.hermes.model.Package;
import com.mkaminski.hermes.model.Order;
import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.service.PackageService;
import com.mkaminski.hermes.service.OrderService;
import com.mkaminski.hermes.service.CourierService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PackageService packageService;

    @Autowired
    private CourierService courierService;



    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrdersPage(Model model, Principal principal) {
        String email = principal.getName();

        Courier courier = courierService.findByEmail(email);

        List<Order> orders;

        if (courier.getRole() == Courier.Role.USER) {
        	orders = orderService.findByCourierOrderByCreatedDateDesc(courier);
        } else {
        	orders = orderService.findAll();
        }

        model.addAttribute("ordersList", orders);

        return "orders";
    }

    @RequestMapping(value = "/order/pack/{packId}")
    public String createOrder(@PathVariable Long packId, Principal principal) {

        String email = principal.getName();

        Package pack = packageService.findOne(packId);
        Courier courier = courierService.findByEmail(email);

        orderService.createOrder(courier, pack);

        return "redirect:/orders";		 
    }
}
