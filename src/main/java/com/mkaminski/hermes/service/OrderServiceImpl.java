package com.mkaminski.hermes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkaminski.hermes.dao.OrderDao;
import com.mkaminski.hermes.dao.PackageDao;
import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.model.Order;
import com.mkaminski.hermes.model.Package;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PackageDao packageDao;

    @Override
    @Transactional
    public void createOrder(Courier courier, Package pack) {
        Order order = new Order(courier, pack);
        orderDao.save(order);
        pack.decrementQuantity();
        packageDao.save(pack);
    }
    public List<Order> findByCourierOrderByCreatedDateDesc(Courier courier) {
    	return orderDao.findByCourierOrderByCreatedDateDesc(courier);
    }

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}
}
