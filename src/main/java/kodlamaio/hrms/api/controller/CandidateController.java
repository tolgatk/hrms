package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.CandidateLoginRequest;
import kodlamaio.hrms.entities.dto.CandidateRegisterRequest;


@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/register")
	@PermitAll
	    public Result candidateregister(
	            @RequestBody CandidateRegisterRequest candidateRegisterRequest
 ){
		return this.candidateService.candidateregister(candidateRegisterRequest);
		
	    }
	@PostMapping("/login")
	public Result candidateLogin(@RequestBody CandidateLoginRequest candidateLoginRequest){
		return this.candidateService.candidateLogin(candidateLoginRequest);
	}


}
