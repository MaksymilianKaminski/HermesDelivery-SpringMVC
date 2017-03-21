package com.mkaminski.hermes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkaminski.hermes.dao.PackageDao;
import com.mkaminski.hermes.model.Package;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageDao packageDao;

	@Override
	public List<Package> findAll() {
		return packageDao.findAll();
	}

	@Override
	public Package findOne(Long id) {
		return packageDao.findOne(id);
	}

	@Override
	public void save(Package pack) {
		packageDao.save(pack);

	}

	@Override
	public void delete(Long id) {
		packageDao.delete(id);

	}

}
