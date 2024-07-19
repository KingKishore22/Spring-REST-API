package com.kishoreb.REST_API.service;

import java.util.List;
import java.util.Optional;

import com.kishoreb.REST_API.entity_table.Employee_TB;

public interface Emp_data_format {
public Employee_TB saveEmployee(Employee_TB table); 
public List<Employee_TB>getAllData();
public Optional<Employee_TB> getEMP_ID(int id);
public Employee_TB getEmployee_by_Id(int id); 
public Employee_TB upDateEmployee(Employee_TB table,int id); 
public void Delete(int id);
}
