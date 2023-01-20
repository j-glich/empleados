package com.mx.CrudEmpleados.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmpleados.dominio.Jobs;

public interface JobsDao extends  CrudRepository<Jobs, Integer> {

}
