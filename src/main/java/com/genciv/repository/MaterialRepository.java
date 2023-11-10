package com.genciv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genciv.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
