package kodlamaio.hrms.business.concrates;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concrates.User;

import kodlamaio.hrms.entities.dto.UserLoginRequest;

import lombok.Data;
@Data
@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Data listlendi");		
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Kullanıcı Silindi");
	}

	@Override
	public DataResult<User> login(UserLoginRequest loginRequest) {
		
	        if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
	            return new ErrorDataResult<>("Email ve şifre zorunludur!");
	        }
	        User user = userDao.findByEmail(loginRequest.getEmail());
	        if (user == null) {
	            return new ErrorDataResult<>("Kullanıcı bulunamadı!");
	        }
	        if (!user.getPassword().equals(loginRequest.getPassword())) {
	            return new ErrorDataResult<>("Şifre hatalı!");
	        }

	        return new SuccessDataResult<>(user, "Başarılı giriş yapıldı");
	}

	@Override
	public Result update(User user) {
		
		
		
		return null;
	}

	@Override
	public Result getById(int id) {
		User user = userDao.findById(id).get();
		return new SuccessDataResult<>(user, "User listelendi");
	}
}





//tolgatok34@hotmail.com
//tolga123


	
	
	




	





	
	


