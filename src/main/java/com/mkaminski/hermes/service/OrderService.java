package com.mkaminski.hermes.service;


import java.util.List;

import com.mkaminski.hermes.model.Package;
import com.mkaminski.hermes.model.Order;
import com.mkaminski.hermes.model.Courier;

public interface OrderService {

    void createOrder(Courier courier, Package pack);
    List<Order> findByCourierOrderByCreatedDateDesc(Courier courier);
    List<Order> findAll();
}
