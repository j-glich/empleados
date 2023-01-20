package com.mx.CrudEmpleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CrudEmpleados.dominio.Genders;
import com.mx.CrudEmpleados.servicio.GendersServImp;

@Controller
//lleva la direccion del contolde metodos
@RequestMapping("api/GendersControl")
public class GendersControl {
	@Autowired
	GendersServImp gender;
	
	@GetMapping("listarGenders")
	public String listarGenders(Model model) {
		var lista = gender.listar();
		model.addAttribute("lista", lista);
		return "indexGender";
	}
	
	@GetMapping("alta")
	public String alta() {
		return "altaGender";
		
	}
	
	@PostMapping("guardar")
	public String guardar(Genders gen ) {
		gender.guardar(gen);
		return "redirect:listarGenders";
	}
	
	@GetMapping("editar/{id}")
	public String editar(Genders gen , Model model) {
		gen = gender.buscar(gen);
		model.addAttribute("gen",gen);	
		return "editarGender";
	}
	@PostMapping("update")
	public String update(Genders gen ) {
		gender.editar(gen);
		return "redirect:listarGenders";
	}
	@GetMapping("eliminar/{id}")
	public String eliminar(Genders gen , Model model) {
		gen = gender.buscar(gen);
		model.addAttribute("gen",gen);	
		return "eliminarGender";
	}
	@PostMapping("delete")
	public String delete(Genders gen ) {
		gender.eliminar(gen);
		return "redirect:listarGenders";
	}
	
	
	
	@GetMapping("regresar")
	public String regresar() {
		return "index";
		
	}
	
}
