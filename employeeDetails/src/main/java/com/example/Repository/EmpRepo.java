package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.EmpEntity;

public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {
	

}
