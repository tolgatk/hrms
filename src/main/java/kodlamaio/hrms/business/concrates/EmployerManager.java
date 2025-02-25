package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concrates.Employer;

import kodlamaio.hrms.entities.dto.EmployerLoginRequest;
import kodlamaio.hrms.entities.dto.EmployerRegisterRequest;
import lombok.Data;

@Data
@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result employeRegister(EmployerRegisterRequest employerRegisterRequest) {
		Employer employer = new Employer();
		employer.setEmail(employerRegisterRequest.getEmail());
		employer.setPassword(employerRegisterRequest.getPassword());
		employer.setCompany_name(employerRegisterRequest.getCompany_name());
		employer.setVergino(employerRegisterRequest.getVergino());
		this.employerDao.save(employer);
	return new SuccessResult("Başarılı bir şekilde Kayıt oldunuz");
	
	}

	@Override
	public DataResult<Employer> employerLogin(EmployerLoginRequest employerLoginRequest) {
		 if (employerLoginRequest.getEmail() == null || employerLoginRequest.getPassword() == null) {
	            return new ErrorDataResult<>("Email ve şifre zorunludur!");
	        }
	        Employer employer = employerDao.findByEmail(employerLoginRequest.getEmail());
	        if (employer == null) {
	            return new ErrorDataResult<>("Kullanıcı bulunamadı!");
	        }
	        if (!employer.getPassword().equals(employerLoginRequest.getPassword())) {
	            return new ErrorDataResult<>("Şifre hatalı!");
	        }

	        return new SuccessDataResult<>(employer, "Başarılı giriş yapıldı");
	
	}


	

}
