package com.mx.CrudEmpleados.dominio;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHours {

	@Id
	int id;
	int worked_hours;
	Date worked_date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employees empleados;
	
	public EmployeeWorkedHours() {

	}

	public EmployeeWorkedHours(int id) {
		this.id = id;
	}

	public EmployeeWorkedHours(int id, int worked_hours, Date worked_date, Employees employess) {
		this.id = id;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
		this.empleados = employess;
	}

	@Override
	public String toString() {
		return "EmployeeWorkedHours [id=" + id + ", worked_hours=" + worked_hours + ", worked_date=" + worked_date
				+ ", employess=" + empleados + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	public Employees getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Employees employess) {
		this.empleados = employess;
	}
	
	
	
	
}
