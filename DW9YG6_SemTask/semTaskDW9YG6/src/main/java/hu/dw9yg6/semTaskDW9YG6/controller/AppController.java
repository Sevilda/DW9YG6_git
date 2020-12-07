package hu.dw9yg6.semTaskDW9YG6.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import hu.dw9yg6.semTaskDW9YG6.model.Hospital;
import hu.dw9yg6.semTaskDW9YG6.repository.I_HospitalRepository;

@Controller
public class AppController {
	@Autowired
	I_HospitalRepository hospitalRepo;
	

	@GetMapping("/list")
	private String getAllRooms(Model model){
		model.addAttribute("hospital", hospitalRepo.findAll());
		return "hospital";
	}
	
	@GetMapping("/update/{id}")
	private String getUpdateRoom(Model model, @PathVariable("id") String id){
		int roomidInt = Integer.parseInt(id);
		model.addAttribute("hospital", hospitalRepo.findById(roomidInt).get());
		return "update";
	}
	
	@PostMapping("/update")
	private String updateRoom (Model model, Hospital hospital) {
		model.addAttribute("hospital", hospital);
		if (hospitalRepo.existsById(hospital.getRoomID()))
		hospitalRepo.save(hospital);
		else return "update";
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	private String deleteRoom(@PathVariable("id") String id){
		int idInt = Integer.parseInt(id);
		hospitalRepo.delete(hospitalRepo.findById(idInt).get());
		return "redirect:/list";
	}
	
	@GetMapping("/display/{id}")
	private String displayRoom(@PathVariable("id") String id, Model model){
		int idInt = Integer.parseInt(id);
		model.addAttribute("hospital", hospitalRepo.findById(idInt).get());
		return "displaydetails";
	}
	
	@GetMapping("/new")
	private String newHospital (Model model) {
		Hospital hospital=new Hospital();
		model.addAttribute("hospital", hospital);
		System.out.println("hospital: " + hospital.toString());
		return "newhospital";
	}
	
	@PostMapping("/new")
	private String saveHospital(Hospital hospital, Model model ) {
		System.out.println("new:" + hospital.toString());
		model.addAttribute("hospital", hospital);
		if (!(hospitalRepo.existsById(hospital.getRoomID()))) {
			System.out.println("success");
			hospitalRepo.save(hospital);
			return "redirect:/list";
			}
		else {
			String message="Room already exists";
			model.addAttribute("message", message);
			return "newhospital";
		}
	}
	
}