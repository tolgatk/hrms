package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Experience;
import kodlamaio.hrms.entities.dto.ExperienceAddRequest;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Service
public class ExperienceManager implements ExperienceService{
	
	private final ExperienceDao experienceDao;
	private final CandidateDao candidateDao;
	
	
	@Override
	public Result add(ExperienceAddRequest experienceAddRequest) {
		Optional<Candidate> candidate = this.candidateDao.findById(experienceAddRequest.getUserid());
		Experience experience = new Experience();
		experience.setCandidate(this.candidateDao.findById(experienceAddRequest.getUserid()).get());
		experience.setCompanyName(experienceAddRequest.getCompanyName());
		experience.setPosition(experienceAddRequest.getPosition());
		experience.setStartYear(experienceAddRequest.getStartYear());
		experience.setEndYear(experienceAddRequest.getEndYear());
		
		
		experienceDao.save(experience);
		
		return new SuccessResult("Data eklendi");
	}

	@Override
	public DataResult<List<Experience>> getByUserId(int userId) {
		return new SuccessDataResult<>(this.experienceDao.findByCandidateId(userId),"Data listelendi");
	}


}
