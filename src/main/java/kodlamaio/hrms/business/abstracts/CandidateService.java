package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dto.CandidateLoginRequest;
import kodlamaio.hrms.entities.dto.CandidateRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateService {
	Result candidateregister(CandidateRegisterRequest candidateRegisterRequest);
	Result candidateLogin(CandidateLoginRequest candidateLoginRequest);
	Result uploadImage(int candidateId, MultipartFile file);
	Result deleteImage(int candidateId);

	

	
	
	
}
