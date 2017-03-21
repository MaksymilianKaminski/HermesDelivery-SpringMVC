package com.mkaminski.hermes.service;

import java.util.List;

import com.mkaminski.hermes.model.Package;

public interface PackageService {
	List<Package> findAll();
	Package findOne(Long id);
	void save(Package pack);
	void delete(Long id);
	
}
