package com.mx.CrudEmpleados.servicio;

import java.util.List;

import com.mx.CrudEmpleados.dominio.Employees;

public interface EmployesServ {
	public int guardar(Employees employees);

	public void editar(Employees employees);

	public void eliminar(Employees employees);

	public Employees buscar(Employees employees);

	public List<Employees> listar();
}
