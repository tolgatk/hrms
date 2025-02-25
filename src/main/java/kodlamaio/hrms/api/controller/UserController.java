package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.UserService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concrates.User;
import kodlamaio.hrms.entities.dto.UserLoginRequest;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;


	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	@PostMapping("/add")
	public Result add(User user){
		return this.userService.add(user);
	}
	@DeleteMapping("/delete")
	public Result delete(User user){
		return this.userService.delete(user);
	}

	@PostMapping("/login")
	public Result login(@RequestBody UserLoginRequest loginRequest){
		return this.userService.login(loginRequest);
	}
	@GetMapping("/getById")
	public Result getById(@RequestParam int userId) {
		return this.userService.getById(userId);
	}
	
}
