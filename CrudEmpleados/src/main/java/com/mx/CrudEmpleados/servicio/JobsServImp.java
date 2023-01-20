package com.mx.CrudEmpleados.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmpleados.dao.JobsDao;
import com.mx.CrudEmpleados.dominio.Jobs;






@Service
public class JobsServImp  implements JobsServ{
	
	@Autowired
	JobsDao jobdao;
	@Transactional
	@Override
	public void guardar(Jobs jobs) {
		// TODO Auto-generated method stub
		jobdao.save(jobs);
	}
	@Transactional
	@Override
	public void editar(Jobs jobs) {
		// TODO Auto-generated method stub
		jobdao.save(jobs);
	}
	@Transactional
	@Override
	public void eliminar(Jobs jobs) {
		// TODO Auto-generated method stub
		jobdao.delete(jobs);
	}
	@Transactional(readOnly = true)
	@Override
	public Jobs buscar(Jobs jobs) {
		// TODO Auto-generated method stub
		return jobdao.findById(jobs.getId()).orElse(null);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Jobs> listar() {
		// TODO Auto-generated method stub
		return (List<Jobs>) jobdao.findAll();
	}
	
	

}
