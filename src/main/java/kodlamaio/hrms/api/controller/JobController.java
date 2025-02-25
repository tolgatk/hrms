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

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.Job;
import kodlamaio.hrms.entities.dto.JobCheckRequest;
import kodlamaio.hrms.entities.dto.JobbAddRequest;

@RestController
@RequestMapping("/api/job")
public class JobController {
	
	private JobService jobService;
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	@PostMapping("/addJob")
	Result jobAdd(JobbAddRequest jobbAddRequest) throws Exception{
		return this.jobService.jobAdd(jobbAddRequest);
}
	@GetMapping("/getAllJob")
	DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
	}
	@PostMapping("/activateStatus")
	Result setActivateJob(@RequestBody JobCheckRequest jobCheckRequest)throws Exception{
		return this.jobService.setActivateJob(jobCheckRequest);
	}@DeleteMapping("/deleteJob")
	public boolean removeJob(int id) {
		return this.jobService.removeJob(id);
	}
	
	
	
}
