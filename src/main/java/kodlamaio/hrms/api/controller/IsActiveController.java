package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.IsActiveService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.IsActiveControllRequest;

@RestController
@RequestMapping("/api/IsActive")
public class IsActiveController {
	private IsActiveService activeService;
	
	
	@Autowired
	public IsActiveController(IsActiveService activeService) {
		super();
		this.activeService = activeService;
	}



	@PostMapping("/IsActiveRequest")
	Result isActiveRequest(IsActiveControllRequest activeControllRequest) {
		return this.activeService.isActiveRequest(activeControllRequest);
	}
	
//	@GetMapping("/ActiveControl")
//	Result getIsActive(IsActiveControllRequest activeControllRequest) {
//		return this.activeService.isActiveRequest(activeControllRequest);
//	}
	
}
