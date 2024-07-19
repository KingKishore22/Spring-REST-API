package com.kishoreb.REST_API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishoreb.REST_API.entity_table.Employee_TB;

public interface Emp_Datas extends JpaRepository<Employee_TB, Integer> {

}
