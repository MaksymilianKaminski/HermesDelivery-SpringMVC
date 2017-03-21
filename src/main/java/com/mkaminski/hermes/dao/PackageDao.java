package com.mkaminski.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkaminski.hermes.model.Package;

@Repository
public interface PackageDao extends JpaRepository<Package, Long> {
}
