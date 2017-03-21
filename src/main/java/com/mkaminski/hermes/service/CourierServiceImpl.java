package com.mkaminski.hermes.service;

import com.mkaminski.hermes.dao.CourierDao;
import com.mkaminski.hermes.model.Courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

	@Autowired
	private CourierDao courierDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Courier courier = courierDao.findByEmail(email);
		if (courier == null) {
			throw new UsernameNotFoundException(String.format("%s does not exist in the database!", email));
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + courier.getRole()));

		return new User(courier.getEmail(), courier.getPassword(), authorities);
	}

	@Override
	public void save(Courier courier) {
		courierDao.save(courier);

	}

	@Override
	public Courier findByEmail(String email) {
		return courierDao.findByEmail(email);
	}

	@Override
	public List<Courier> findAll() {
		return courierDao.findAll();
	}

	@Override
	public void delete(Long id) {
		courierDao.delete(id);

	}

	@Override
	public Courier findOne(Long id) {
		return courierDao.findOne(id);
	}
}
