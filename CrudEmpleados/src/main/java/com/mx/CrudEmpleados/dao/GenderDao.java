package com.mx.CrudEmpleados.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmpleados.dominio.Genders;

public interface GenderDao extends CrudRepository<Genders, Integer> {

}
