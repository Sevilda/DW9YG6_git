package hu.dw9yg6.semTaskDW9YG6.controller;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import hu.dw9yg6.semTaskDW9YG6.repository.I_DoctorRepository;

@Controller
public class AppController {
	@Autowired
	//I_DoctorRepository doctorRepository;

	@GetMapping("/list")
	public String getAllDocs(){
	//public String getAllDocs(Model model){
		//model.addAttribute("doctors", doctorRepository.findAll());
		return "doctors";
	}
}