package kodlamaio.hrms.business.concrates;

import jakarta.transaction.Transactional;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Language;
import kodlamaio.hrms.entities.dto.LanguageAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final CandidateDao candidateDao;

    @Override
    public Result add(LanguageAddRequest languageAddRequest) {
        Optional<Candidate>candidate  = this.candidateDao.findById(languageAddRequest.getUserid());
        Language language = new Language();
        language.setCandidate(this.candidateDao.findById(languageAddRequest.getUserid()).get());
        language.setName(languageAddRequest.getName());
        language.setLevel(languageAddRequest.getLevel());
        languageDao.save(language);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Language>> getByUserId(int userId) {
        List<Language> languages = languageDao.findByCandidateId(userId);
        if(languages.isEmpty()) {
            return new ErrorDataResult<>("Bu kullanıcıya ait dil bilgisi bulunamadı");
        }

        return new SuccessDataResult<>(languages, "Data listelendi");
    }

    @Override
    public Result deleteByUserId(int userId) {
        List<Language> languages = languageDao.findByCandidateId(userId);
        if(languages.isEmpty()) {
            return new ErrorResult("Bu kullanıcıya ait dil bilgisi bulunamadı");
        }

        languageDao.deleteByCandidateId(userId);
        return new SuccessResult("Dil bilgileri başarıyla silindi");


}
}