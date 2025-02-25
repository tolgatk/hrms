package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.Experience;
import kodlamaio.hrms.entities.dto.ExperienceAddRequest;

import java.util.List;

public interface ExperienceService {
	
	Result add(ExperienceAddRequest experienceAddRequest);
	DataResult<List<Experience>> getByUserId(int userId);

}
