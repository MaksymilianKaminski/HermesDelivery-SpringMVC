package com.mkaminski.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkaminski.hermes.model.Courier;

@Repository
public interface CourierDao extends JpaRepository<Courier, Long> {

    Courier findByEmail(String email);

}



