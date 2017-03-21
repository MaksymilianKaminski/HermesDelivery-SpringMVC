package com.mkaminski.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkaminski.hermes.model.Order;
import com.mkaminski.hermes.model.Courier;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

    List<Order> findByCourierOrderByCreatedDateDesc(Courier courier);

}
