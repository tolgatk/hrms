package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.CityAddRequest;

public interface CityService {
	Result cityAdd(CityAddRequest cityAddRequest);
}
