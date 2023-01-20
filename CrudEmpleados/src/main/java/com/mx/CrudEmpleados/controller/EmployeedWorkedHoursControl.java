package com.mx.CrudEmpleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CrudEmpleados.dominio.EmployeeWorkedHours;
import com.mx.CrudEmpleados.servicio.EmployeeWorkedHoursServImp;
import com.mx.CrudEmpleados.servicio.EmployesServImp;

@Controller
@RequestMapping("api/EmployeedWorkedHoursControl")
public class EmployeedWorkedHoursControl {

	@Autowired
	EmployeeWorkedHoursServImp ewhs;

	@Autowired
	EmployesServImp emplo;

	@GetMapping("listar")
	public String listar(Model model) {
		var lista = ewhs.listar();
		model.addAttribute("lista", lista);
		return "indexEmployeedWorkedHours";
	}

	@GetMapping("alta")
	public String alta(Model model) {
		var lista = emplo.listar();
		model.addAttribute("empleado", lista);
		return "altaEmployeedWorkedHours";
	}

	@PostMapping("guardar")
	public String alta(EmployeeWorkedHours ewh) {
		ewhs.guardar(ewh);
		return "redirect:listar";

	}

	@GetMapping("editar/{id}")
	public String editar(EmployeeWorkedHours ewh, Model model) {
		ewh = ewhs.buscar(ewh);
		model.addAttribute("ewh", ewh);
		var lista = emplo.listar();
		model.addAttribute("empleado", lista);
		return "editarEmployeedWorkedHours";
	}

	@PostMapping("update")
	public String update(EmployeeWorkedHours ewh) {
		ewhs.editar(ewh);
		return "redirect:listar";
	}

	@GetMapping("eliminar/{id}")
	public String eliminar(EmployeeWorkedHours ewh, Model model) {
		ewh = ewhs.buscar(ewh);
		model.addAttribute("ewh", ewh);
		var lista = emplo.listar();
		model.addAttribute("empleado", lista);
		return "eliminarEmployeedWorkedHours";
	}

	@PostMapping("delete")
	public String delete(EmployeeWorkedHours ewh) {
		ewhs.eliminar(ewh);
		return "redirect:listar";
	}

	@GetMapping("regresar")
	public String regresar() {
		return "index";

	}
}
