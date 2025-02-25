package kodlamaio.hrms.business.concrates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

import kodlamaio.hrms.entities.concrates.Candidate;

import kodlamaio.hrms.entities.dto.CandidateLoginRequest;
import kodlamaio.hrms.entities.dto.CandidateRegisterRequest;

import lombok.Data;
@Data
@Service

public class CandidateManager implements CandidateService {
	

	private CandidateDao candidateDao;
	
	@Autowired
	
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	


	@Override
	public Result candidateregister(CandidateRegisterRequest candidateRegisterRequest) {
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateRegisterRequest.getFirstname());
		candidate.setLastName(candidateRegisterRequest.getLastname());
		candidate.setPassword(candidateRegisterRequest.getPassword());
		candidate.setEmail(candidateRegisterRequest.getEmail());
		candidate.setTckimlik_no(candidateRegisterRequest.getTckimlik_no());
		this.candidateDao.save(candidate);
		return new SuccessResult("Başarılı Kayıt Oldunuz.");
		
	}



	@Override
	public DataResult<Candidate> candidateLogin(CandidateLoginRequest candidateLoginRequest) {
		 if (candidateLoginRequest.getEmail() == null || candidateLoginRequest.getPassword() == null) {
	            return new ErrorDataResult<>("Email ve şifre zorunludur!");
	        }
		 Candidate candidate = candidateDao.findByEmail(candidateLoginRequest.getEmail());
	        if (candidate == null) {
	            return new ErrorDataResult<>("Kullanıcı bulunamadı!");
	        }
	        if (!candidate.getPassword().equals(candidateLoginRequest.getPassword())) {
	            return new ErrorDataResult<>("Şifre hatalı!");
	        }
	        return new  SuccessDataResult<>(candidate, "Başarılı giriş yapıldı");
	      
	
	}









	








	








	
	
	
	
}
