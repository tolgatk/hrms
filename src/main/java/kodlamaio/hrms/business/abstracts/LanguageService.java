package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.Language;
import kodlamaio.hrms.entities.dto.LanguageAddRequest;

import java.util.List;

public interface LanguageService {

        Result add(LanguageAddRequest languageAddRequest);
        DataResult<List<Language>> getByUserId(int userId);
        Result deleteByUserId(int userId);

}
