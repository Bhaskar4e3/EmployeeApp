package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.EmpEntity;
import com.example.Repository.EmpRepo;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class EmpController {
	
	@Autowired
	private EmpRepo empRepo;
	@PostConstruct
	public void preSaved() {
	
		
		
		
	List<EmpEntity> e=new ArrayList<>();
	e.add(new EmpEntity(1, "bhaskar1", "IT", 3000));
	e.add(new EmpEntity(2, "bhaskar2", "NON-IT", 7000));
	e.add(new EmpEntity(3, "bhaskar3", "IT", 10000));
	e.add(new EmpEntity(4, "bhaskar4", "NON-IT", 4000));
	e.add(new EmpEntity(5, "bhaskar5", "IT", 15000));
	
	for(EmpEntity es:e) {
		empRepo.save(es);
	}
	
	
	
	}

	
	@PostMapping("/saveall")
	public ResponseEntity<String> save(@RequestBody List<EmpEntity> emp ) {
		for(EmpEntity e:emp) {
	            empRepo.save(e);
		}
		return new ResponseEntity<String>("emp saved successfully",HttpStatus.CREATED);
		
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody EmpEntity emp ) {
	
	            empRepo.save(emp);
		
		return new ResponseEntity<String>("emp saved successfully",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findall")
	public  ResponseEntity<List<EmpEntity>> findall() {
	List<EmpEntity> empAll= empRepo.findAll();
	 return new ResponseEntity<List<EmpEntity>>(empAll,HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/update")
	public EmpEntity updateEmp(@RequestBody EmpEntity e) {
		   EmpEntity e1=empRepo.findById(e.getId()).get();
		   System.out.println(e1.toString());
		   e1.setSalary(e.getSalary());
		 EmpEntity updated=  empRepo.save(e1);
		   return updated;
		
	}
	@RequestMapping("/savec")
	public String savec(@RequestParam int id,@RequestParam("name") String name,@RequestParam("dept") String dept,@RequestParam("salary") long salary) {
		EmpEntity e=new EmpEntity();
		e.setId(id);
		e.setName(name);
		e.setDept(dept);
		e.setSalary(salary);
		empRepo.save(e);
		return "saved from google successfully";
	}
	@RequestMapping("/updateName")
	public ResponseEntity<EmpEntity> name(@RequestParam String name,@RequestParam int id) {
	EmpEntity e=	empRepo.findById(id).get();
	e.setName(name);
	EmpEntity eu=empRepo.save(e);
	return new ResponseEntity<EmpEntity>(eu,HttpStatus.OK);	
		}
	@RequestMapping("/updateDept")
	public ResponseEntity<EmpEntity> dept(@RequestParam String dept,@RequestParam int id) {
	EmpEntity e=	empRepo.findById(id).get();
	e.setDept(dept);
	EmpEntity eu=empRepo.save(e);
	return new ResponseEntity<EmpEntity>(eu,HttpStatus.OK);	
		}
	@RequestMapping("/updateSalary")
	public ResponseEntity<EmpEntity> salary(@RequestParam long salary,@RequestParam int id) {
	EmpEntity e=	empRepo.findById(id).get();
	e.setSalary(salary);
	EmpEntity eu=empRepo.save(e);
	return new ResponseEntity<EmpEntity>(eu,HttpStatus.OK);	
		}
	@RequestMapping("/deleteByid")
	public String delete(@RequestParam int id) {
		empRepo.deleteById(id);
		return "deleted";
	}
}
