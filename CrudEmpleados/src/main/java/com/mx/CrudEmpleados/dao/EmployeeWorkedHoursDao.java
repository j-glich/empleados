package com.mx.CrudEmpleados.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmpleados.dominio.EmployeeWorkedHours;

public interface EmployeeWorkedHoursDao extends CrudRepository<EmployeeWorkedHours, Integer> {

}
