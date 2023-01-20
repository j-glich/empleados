package com.mx.CrudEmpleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmpleados.dao.GenderDao;
import com.mx.CrudEmpleados.dominio.Genders;

@Service
public class GendersServImp implements GendersServ {
	@Autowired
	GenderDao gendersDao;
	@Transactional
	@Override
	public void guardar(Genders genders) {
		// TODO Auto-generated method stub
		gendersDao.save(genders);
	}
	@Transactional
	@Override
	public void editar(Genders genders) {
		// TODO Auto-generated method stub
		gendersDao.save(genders);
	}
	@Transactional
	@Override
	public void eliminar(Genders genders) {
		// TODO Auto-generated method stub
		gendersDao.delete(genders);
	}
	@Transactional(readOnly = true)
	@Override
	public Genders buscar(Genders genders) {
		// TODO Auto-generated method stub
		return gendersDao.findById(genders.getId()).orElse(null);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Genders> listar() {
		// TODO Auto-generated method stub
		return (List<Genders>) gendersDao.findAll();
	}

}
