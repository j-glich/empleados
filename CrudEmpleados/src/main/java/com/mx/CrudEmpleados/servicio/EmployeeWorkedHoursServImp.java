package com.mx.CrudEmpleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmpleados.dao.EmployeeWorkedHoursDao;
import com.mx.CrudEmpleados.dominio.EmployeeWorkedHours;

@Service
public class EmployeeWorkedHoursServImp implements EmployeeWorkedHoursServ {

	
	@Autowired
	EmployeeWorkedHoursDao dao;
	@Transactional
	@Override
	public void guardar(EmployeeWorkedHours employeeh) {
		// TODO Auto-generated method stub
		dao.save(employeeh);
	}
	@Transactional
	@Override
	public void editar(EmployeeWorkedHours employeeh) {
		// TODO Auto-generated method stub
		dao.save(employeeh);
	}
	@Transactional
	@Override
	public void eliminar(EmployeeWorkedHours employeeh) {
		// TODO Auto-generated method stub
		dao.delete(employeeh);
	}
	@Transactional(readOnly = true)
	@Override
	public EmployeeWorkedHours buscar(EmployeeWorkedHours employeeh) {
		// TODO Auto-generated method stub
		return dao.findById(employeeh.getId()).orElse(null);
	}
	@Transactional(readOnly = true)
	@Override
	public List<EmployeeWorkedHours> listar() {
		// TODO Auto-generated method stub
		return (List<EmployeeWorkedHours>) dao.findAll();
	}

}
