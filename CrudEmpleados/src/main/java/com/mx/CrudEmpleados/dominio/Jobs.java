package com.mx.CrudEmpleados.dominio;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Para persitencia de datos de esteoripo o notaciones
@Entity
//indica que pertenece a una tabala
@Table(name = "JOBS") 
public class Jobs {
	@Id
	int id;
	String name;
	double salary;
	
	@OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
	List<Employees> lista = new ArrayList<Employees>();

	public Jobs() {

	}
	public Jobs(int id) {
		this.id = id;
	}
	public Jobs(int id, String name, double salary, List<Employees> lista) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	


	
	
}