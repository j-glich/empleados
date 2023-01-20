package com.mx.CrudEmpleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.CrudEmpleados.dominio.Employees;
import com.mx.CrudEmpleados.servicio.EmployesServImp;
import com.mx.CrudEmpleados.servicio.GendersServImp;
import com.mx.CrudEmpleados.servicio.JobsServImp;

@Controller
//lleva la direccion del contolde metodos
@RequestMapping("api/EmployeedControl")
public class EmployeedControl {

	@Autowired
	EmployesServImp emplos;

	@Autowired
	GendersServImp genders;
	@Autowired
	JobsServImp jobs;

	@GetMapping("listarEmploayeed")
	public String listarGenders(Model model) {
		var lista = emplos.listar();
		model.addAttribute("lista", lista);
		return "indexEmployeed";
	}

	@GetMapping("alta")
	public String alta(Model model) {
		var gender = genders.listar();
		model.addAttribute("gender", gender);
		var job = jobs.listar();
		model.addAttribute("job", job);
		return "altaEmployeed";
	}
	@PostMapping("guardar")
	public String guardar(Employees emplo,  RedirectAttributes redirectAttrs) {
	    int respuesta =	emplos.guardar(emplo);
	    
	    if (respuesta == 1) {
	    	redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
		}else {
			redirectAttrs
            .addFlashAttribute("mensaje", "No se pudo agregar correctamente")
            .addFlashAttribute("clase", "danger");
		}
	    
		return "redirect:listarEmploayeed";
	}


	@GetMapping("editar/{id}")
	public String editar(Employees emp , Model model) {
		emp = emplos.buscar(emp);
		model.addAttribute("emplo",emp);	
		var gender = genders.listar();
		model.addAttribute("gender", gender);
		var job = jobs.listar();
		model.addAttribute("job", job);
		return "editarEmployeed";
	}
	@PostMapping("update")
	public String update(Employees emp ) {
		emplos.editar(emp);
		return "redirect:listarEmploayeed";
	}
	@GetMapping("eliminar/{id}")
	public String eliminar(Employees emp , Model model) {
		emp = emplos.buscar(emp);
		model.addAttribute("emplo",emp);
		var gender = genders.listar();
		model.addAttribute("gender", gender);
		var job = jobs.listar();
		model.addAttribute("job", job);
		return "eliminarEmployeed";
	}
	@PostMapping("delete")
	public String delete(Employees emp ) {
		emplos.eliminar(emp);
		return "redirect:listarEmploayeed";
	}
	

	@GetMapping("regresar")
	public String regresar() {
		return "index";
		
	}
	
	
}
