package com.kishoreb.REST_API.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishoreb.REST_API.entity_table.Employee_TB;
import com.kishoreb.REST_API.exception.Resource_not_found;
import com.kishoreb.REST_API.service.Business_logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class Hpage {
	@Autowired
	Business_logic logic;
	
@PostMapping("/add")	
public ResponseEntity<Employee_TB>saveEmp(@RequestBody Employee_TB tb)
{
	return new ResponseEntity<Employee_TB>(logic.saveEmployee(tb),HttpStatus.CREATED);
	
}

@CrossOrigin(origins = "http://localhost:3004")
@GetMapping("/get")
public List<Employee_TB>getdatas()
{
	return logic.getAllData(); 
}

@GetMapping("/get/{id}")
public Employee_TB getbbyID(@PathVariable int id)
{
	Optional<Employee_TB>opt=logic.getEMP_ID(id);
	if(opt.isPresent())
	{
		System.out.println(opt.get().getId()+opt.get().getName()+opt.get().getDept());
		return opt.get();
	}
	else {
		throw new Resource_not_found("Employee","ID",id);
	}
}

@PutMapping("getid/{id}")	
public ResponseEntity<Employee_TB>get_Employye_by_Id(@PathVariable int id,  @RequestBody Employee_TB tb)
{
	return new ResponseEntity<Employee_TB>(logic.upDateEmployee(tb,id),HttpStatus.OK);
	
}

@DeleteMapping("del/{id}")
public ResponseEntity<String>delete_by_Id(@PathVariable int id)
{
	logic.Delete(id);
	return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	
}

@PutMapping("getup/{id}")	
public ResponseEntity<Employee_TB>updateEmp(@PathVariable int id,  @RequestBody Employee_TB tb)
{
	return new ResponseEntity<Employee_TB>(logic.upDateEmployee(tb,id),HttpStatus.OK);
	
}
}
