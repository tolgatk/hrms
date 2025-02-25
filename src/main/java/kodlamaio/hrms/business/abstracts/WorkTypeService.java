package kodlamaio.hrms.business.abstracts;



import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.WorkAddRequest;

public interface WorkTypeService {
	Result workTaypeAdd(WorkAddRequest workAddRequest);
}
