package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.User;
import kodlamaio.hrms.entities.dto.UserLoginRequest;



public interface UserService {
	
	DataResult<List<User>> getAll();
	Result add(User user);
	Result getById(int id);
	Result delete(User user);
	Result login(UserLoginRequest loginRequest);
	Result update(User user);
	
	
	
	
}
