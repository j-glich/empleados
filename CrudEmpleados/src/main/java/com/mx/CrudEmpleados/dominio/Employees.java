package com.mx.CrudEmpleados.dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {
	@Id
	int id;
	String name;
	String last_name;
	Date birthdate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Genders genders;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Jobs jobs;

	@OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL)
	List<EmployeeWorkedHours> lista = new ArrayList<EmployeeWorkedHours>();
	
	public Employees() {

	}

	public Employees(int id) {

		this.id = id;
	}



	public Employees(int id, String name, String last_name, Date birthdate, Genders genders, Jobs jobs,
			List<EmployeeWorkedHours> lista) {
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.genders = genders;
		this.jobs = jobs;
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", last_name=" + last_name + ", birthdate=" + birthdate
				+ ", genders=" + genders + ", jobs=" + jobs + "]\n";
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Genders getGenders() {
		return genders;
	}

	public void setGenders(Genders genders) {
		this.genders = genders;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	
	
	
	
}
