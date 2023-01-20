package com.mx.CrudEmpleados.servicio;

import java.util.List;

import com.mx.CrudEmpleados.dominio.EmployeeWorkedHours;

public interface EmployeeWorkedHoursServ {
	public void guardar(EmployeeWorkedHours employeeh);

	public void editar(EmployeeWorkedHours employeeh);

	public void eliminar(EmployeeWorkedHours employeeh);

	public EmployeeWorkedHours buscar(EmployeeWorkedHours employeeh);

	public List<EmployeeWorkedHours> listar();
}
