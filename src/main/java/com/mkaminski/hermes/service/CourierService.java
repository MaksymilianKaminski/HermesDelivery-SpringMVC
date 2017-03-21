package com.mkaminski.hermes.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mkaminski.hermes.model.Courier;

public interface CourierService extends UserDetailsService {
	void save(Courier courier);
	Courier findByEmail(String email);
	List<Courier> findAll();
	void delete(Long id);
	Courier findOne(Long id);
}
