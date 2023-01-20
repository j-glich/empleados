package com.mx.CrudEmpleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CrudEmpleados.dominio.Jobs;
import com.mx.CrudEmpleados.servicio.JobsServImp;

@Controller
//lleva la direccion del contolde metodos
@RequestMapping("api/JobsControl")
public class JobsControl {
	
	@Autowired
	JobsServImp jobs;
	
	@GetMapping("listar")
	public String listar(Model model) {
		var lista = jobs.listar();
		model.addAttribute("lista", lista);
		return "indexJobs";
		
	}
	@GetMapping("alta")
	public String alta() {
		return "altaJobs";
		
	}
	
	@PostMapping("guardar")
	public String guardar(Jobs job ) {
		jobs.guardar(job);
		return "redirect:listar";
	}
	
	@GetMapping("editar/{id}")
	public String editar(Jobs job , Model model) {
		job = jobs.buscar(job);
		model.addAttribute("job",job);	
		return "editarJobs";
	}
	@PostMapping("update")
	public String update(Jobs job ) {
		jobs.editar(job);
		return "redirect:listar";
	}
	@GetMapping("eliminar/{id}")
	public String eliminar(Jobs job , Model model) {
		job = jobs.buscar(job);
		model.addAttribute("job",job);	
		return "eliminarJobs";
	}
	@PostMapping("delete")
	public String delete(Jobs job ) {
		jobs.eliminar(job);
		return "redirect:listar";
	}
	@GetMapping("regresar")
	public String regresar() {
		return "index";
		
	}
	
	
	
}
