package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.EmployerLoginRequest;
import kodlamaio.hrms.entities.dto.EmployerRegisterRequest;

public interface EmployerService {
	
	Result employeRegister(EmployerRegisterRequest employerRegisterRequest);
	Result employerLogin(EmployerLoginRequest employerLoginRequest);
	

}
