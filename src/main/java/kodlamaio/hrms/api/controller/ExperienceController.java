package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concrates.Experience;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.ExperienceAddRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	
	private final ExperienceService experienceService;
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceAddRequest experienceAddRequest) {
		return experienceService.add(experienceAddRequest);
	}

	@GetMapping("/getUserById")
	public DataResult<List<Experience>> getByUserId(@RequestParam int candidateId) {
		return experienceService.getByUserId(candidateId);
	}

	@DeleteMapping("/delete")
	Result deleteByUserId(@RequestParam int userId){
		return experienceService.deleteByUserId(userId);
	}

}
