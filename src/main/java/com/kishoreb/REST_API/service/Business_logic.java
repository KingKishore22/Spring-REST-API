package com.kishoreb.REST_API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishoreb.REST_API.entity_table.Employee_TB;
import com.kishoreb.REST_API.exception.Resource_not_found;
import com.kishoreb.REST_API.repositories.Emp_Datas;

@Repository
public class Business_logic implements Emp_data_format {

	@Autowired
	Emp_Datas data;

	@Override
	public Employee_TB saveEmployee(Employee_TB table) {
		// TODO Auto-generated method stub
		return data.save(table);
	}

	@Override
	public List<Employee_TB> getAllData() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public Optional<Employee_TB> getEMP_ID(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public Employee_TB upDateEmployee(Employee_TB table, int id) {
		// TODO Auto-generated method stub
		Optional<Employee_TB>tbs=data.findById(id);
	
		if(tbs.isPresent())
		{
			Employee_TB tab=tbs.get();
			tab.setName(table.getName());
			tab.setDept(table.getDept());
			data.save(tab);
			return tab;
		}
		else {
			throw new Resource_not_found("name", "not", "found");
		}
		
	}

	@Override
	public Employee_TB getEmployee_by_Id(int id) {
		// TODO Auto-generated method stub
		Optional<Employee_TB>tbs=data.findById(id);
	if(tbs.isPresent())	
	{
		return tbs.get();
	}
 throw new Resource_not_found("val", "not", "found"); 
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
	data.deleteById(id);	
	}
}
	

