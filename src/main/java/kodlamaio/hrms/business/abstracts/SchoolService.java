package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.School;
import kodlamaio.hrms.entities.dto.SchoolAddRequset;
import java.util.List;


public interface SchoolService {

    Result add (SchoolAddRequset schoolAddRequset);
    DataResult<List<School>>getByUserId(int userid);
    Result deleteByUserId(int userid);




}
