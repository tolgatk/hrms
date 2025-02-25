package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Experience;
import kodlamaio.hrms.entities.dto.ExperienceAddRequest;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@Service
@Transactional
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
		List<Experience> experiences = experienceDao.findByCandidateId(userId);
		if(experiences.isEmpty()) {
			return new ErrorDataResult<>("Bu kullanıcıya ait deneyim bulunamadı");
		}

		return new SuccessDataResult<>(this.experienceDao.findByCandidateId(userId),"Data listelendi");
	}

	@Override
	public Result deleteByUserId(int userId) {
		List<Experience> experiences = experienceDao.findByCandidateId(userId);
		if(experiences.isEmpty()) {
			return new ErrorResult("Bu kullanıcıya ait deneyim bulunamadı");
		}

		experienceDao.deleteByCandidateId(userId);
		return new SuccessResult("Deneyimler başarıyla silindi");
	}


}
