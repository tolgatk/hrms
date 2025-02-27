package kodlamaio.hrms.business.concrates;

import jakarta.transaction.Transactional;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.School;
import kodlamaio.hrms.entities.dto.SchoolAddRequset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;
    private final CandidateDao candidateDao;

    @Override
    public Result add(SchoolAddRequset schoolAddRequset) {
        Optional<Candidate>candidate=this.candidateDao.findById(schoolAddRequset.getUserid());
        School school = new School();
        school.setCandidate(this.candidateDao.findById(schoolAddRequset.getUserid()).get());
        school.setName(schoolAddRequset.getName());
        school.setDepartment(schoolAddRequset.getDepartment());
        school.setStartYear(schoolAddRequset.getStartYear());
        school.setEndYear(schoolAddRequset.getEndYear());
        schoolDao.save(school);
        return new SuccessResult("Başarıyla üye eklendi");
    }

    @Override
    public DataResult<List<School>> getByUserId(int userid) {
        List<School> schools = schoolDao.findByCandidateId(userid);
        if (schools.isEmpty()){
            return new ErrorDataResult<>("Bu kullanıcıya ait okul bulunamadı");
        }
        return new SuccessDataResult<>(this.schoolDao.findByCandidateId(userid),"Data listelendi");
    }

    @Override
    public Result deleteByUserId(int userid) {
        List<School> schools = schoolDao.findByCandidateId(userid);
        if (schools.isEmpty()){
            return new ErrorDataResult<>("Bu kullanıcıya ait okul bulunamadı");
        }schoolDao.deleteByCandidateId(userid);
        return new SuccessResult("Kullanıcıya ait okul silindi");
    }
}
