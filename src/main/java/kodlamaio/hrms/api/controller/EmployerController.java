package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import kodlamaio.hrms.business.abstracts.EmployerService;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dto.EmployerLoginRequest;
import kodlamaio.hrms.entities.dto.EmployerRegisterRequest;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
	
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/register")
	@PermitAll
	public Result employeRegister(@RequestBody EmployerRegisterRequest employerRegisterRequest) {
		return this.employerService.employeRegister(employerRegisterRequest);
	}
	@PermitAll
	@PostMapping("/login")
	public Result employerLogin(@RequestBody EmployerLoginRequest employerLoginRequest){
		return this.employerService.employerLogin(employerLoginRequest);
	}
	

}
