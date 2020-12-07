package hu.dw9yg6.semTaskDW9YG6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.dw9yg6.semTaskDW9YG6.repository.I_HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	I_HospitalRepository hospitalRepo;
	
}
