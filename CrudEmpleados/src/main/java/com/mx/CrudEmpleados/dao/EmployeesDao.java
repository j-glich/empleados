package com.mx.CrudEmpleados.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmpleados.dominio.Employees;

public interface EmployeesDao extends CrudRepository<Employees, Integer> {

}
