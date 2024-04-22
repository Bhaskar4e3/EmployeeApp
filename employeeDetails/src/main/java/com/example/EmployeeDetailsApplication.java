package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Entity.EmpEntity;
import com.example.Repository.EmpRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EmployeeDetailsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
	
	}

}
