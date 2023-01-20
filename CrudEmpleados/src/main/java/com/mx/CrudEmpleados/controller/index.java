package com.mx.CrudEmpleados.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CrudEmpleados.dominio.Employees;
import com.mx.CrudEmpleados.servicio.EmployeeWorkedHoursServImp;
import com.mx.CrudEmpleados.servicio.EmployesServImp;
import com.mx.CrudEmpleados.servicio.GendersServImp;
import com.mx.CrudEmpleados.servicio.JobsServImp;



@Controller
//lleva la direccion del contolde metodos
@RequestMapping("api/index")
public class index {
	@GetMapping("listar")
	public String listar() {
		return "index";
		
	}
	
	@Autowired
	JobsServImp job;
	
	@Autowired
	GendersServImp gender;
	
	@Autowired
	EmployesServImp emplo;
	
	@Autowired
	EmployeeWorkedHoursServImp ewh;
	
	@GetMapping("listarJobs")
	public String listarJobs(Model model) {
		var lista = job.listar();
		model.addAttribute("lista", lista);
		return "indexJobs";
	}
	
	@GetMapping("listarGenders")
	public String listarGenders(Model model) {
		var lista = gender.listar();
		model.addAttribute("lista", lista);
		return "indexGender";
	}

	@GetMapping("listarEmployees")
	public String listarEmployees(Model model) {
		var lista = emplo.listar();
		model.addAttribute("lista", lista);
		return "indexEmployeed";
	}
	
	@GetMapping("listarEWH")
	public String listar(Model model) {
		var lista = ewh.listar();
		model.addAttribute("lista", lista);
		return "indexEmployeedWorkedHours";
	}

	
	@PostMapping("buscaxAtributo")
	public String buscaxAtributo(Model model , String emp){
		List<Employees> lista = (List<Employees>) emplo.listaEmpleadosxJob(emp);
		model.addAttribute("lista", lista);
		return "indexEmployeed";
	}
	
	
}
