package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.Job;
import kodlamaio.hrms.entities.dto.JobCheckRequest;
import kodlamaio.hrms.entities.dto.JobbAddRequest;


public interface JobService {
	
	Result jobAdd(JobbAddRequest jobbAddRequest) throws Exception;
	DataResult<List<Job>> getAll();
	Result setActivateJob(JobCheckRequest jobCheckRequest)throws Exception;
	boolean removeJob(int id); 
}
