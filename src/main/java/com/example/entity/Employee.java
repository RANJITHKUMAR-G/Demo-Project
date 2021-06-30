package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private String date;
	private String gender;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Employee(int id, String name, String date, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.gender = gender;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
