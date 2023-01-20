package com.mx.CrudEmpleados.servicio;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmpleados.dao.EmployeesDao;
import com.mx.CrudEmpleados.dominio.Employees;


@Service
public class EmployesServImp implements EmployesServ {

	@Autowired
	EmployeesDao employeesDao;

	@Transactional
	@Override
	public int guardar(Employees employees) {
		// TODO Auto-generated method stub
		int aux = 0, execute= 0;

		for (Employees emp : employeesDao.findAll()) {
			if (emp.getName().equals(employees.getName()) && emp.getLast_name().equals(employees.getLast_name())  )
				aux++;
		}
		Period edad = Period.between(employees.getBirthdate().toLocalDate(), LocalDate.now());
		if (aux > 0  ) {
			System.out.println("No se pudo registar ya esta registrado");
			execute=0;
		}else {
			if(edad.getYears() < 18) {
				System.out.println("Usuario no es mayor de edad");
				execute=0;
			}else {
				execute=1;
				employeesDao.save(employees);
			}
			
		}
		return execute;
	}

	@Transactional
	@Override
	public void editar(Employees employees) {
		// TODO Auto-generated method stub
		employeesDao.save(employees);
	}

	@Transactional
	@Override
	public void eliminar(Employees employees) {
		// TODO Auto-generated method stub
		employeesDao.delete(employees);
	}

	@Transactional(readOnly = true)
	@Override
	public Employees buscar(Employees employees) {
		// TODO Auto-generated method stub
		return employeesDao.findById(employees.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employees> listar() {
		// TODO Auto-generated method stub
		return (List<Employees>) employeesDao.findAll();
	}
	public List<Employees> listaEmpleadosxJob(String aut) {
		
		// TODO Auto-generated method stub
		List<Employees> lista1 = new ArrayList<>();
		List<Employees> listaAux = (List<Employees>) employeesDao.findAll();
		for(Employees empl: listaAux) {
			if(empl.getJobs().getName().equals(aut)) {
				lista1.add(empl);
				
				System.out.println("si entro");
			}
		}
		
		System.out.println(lista1);
		return lista1;
	}

}
