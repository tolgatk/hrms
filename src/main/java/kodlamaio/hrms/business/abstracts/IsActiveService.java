package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.IsActiveControllRequest;

public interface IsActiveService {
	Result isActiveRequest(IsActiveControllRequest activeControllRequest);
//	Result getIsActive(IsActiveControllRequest activeControllRequest);
}
