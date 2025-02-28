package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.entities.concrates.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.security.PermitAll;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.CandidateLoginRequest;
import kodlamaio.hrms.entities.dto.CandidateRegisterRequest;
import org.springframework.web.multipart.MultipartFile;


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

	@PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result uploadImage(
			@RequestParam("candidateId") int candidateId,
			@RequestParam("file") MultipartFile file) {
		return this.candidateService.uploadImage(candidateId, file);
	}
	@DeleteMapping(value = "/delete-image")
	Result deleteImage(
			@RequestParam int candidateId){
		return this.candidateService.deleteImage(candidateId);
	}


}
