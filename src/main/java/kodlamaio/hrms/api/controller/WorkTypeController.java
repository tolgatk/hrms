package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.WorkAddRequest;

@RestController
@RequestMapping("/api/worktype")
public class WorkTypeController {
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/addWorkType")
	Result workTaypeAdd(@RequestBody WorkAddRequest workAddRequest) {
		return this.workTypeService.workTaypeAdd(workAddRequest);
	}

	
	
}
