package com.kishoreb.REST_API.entity_table;

import jakarta.persistence.*;

@Entity
public class Employee_TB {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column
int id;
@Column
String name;
@Column
String dept;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}

}
