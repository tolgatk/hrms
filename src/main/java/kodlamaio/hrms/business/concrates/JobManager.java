package kodlamaio.hrms.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.IsActiveDao;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concrates.City;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.IsActive;
import kodlamaio.hrms.entities.concrates.Job;
import kodlamaio.hrms.entities.concrates.WorkType;
import kodlamaio.hrms.entities.dto.JobCheckRequest;
import kodlamaio.hrms.entities.dto.JobbAddRequest;
import lombok.Data;

@Data
@Service
public class JobManager implements JobService {

	private EmployerDao employerDao;
	private CityDao cityDao;
	private WorkTypeDao workTypeDao;
	private IsActiveDao isActiveDao;
	private JobDao jobDao;

	@Autowired
	public JobManager(EmployerDao employerDao, CityDao cityDao, WorkTypeDao workTypeDao, IsActiveDao isActiveDao,
			JobDao jobDao) {
		super();
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.workTypeDao = workTypeDao;
		this.isActiveDao = isActiveDao;
		this.jobDao = jobDao;
	}

	@Override
	public Result jobAdd(JobbAddRequest jobbAddRequest) throws Exception {
		Job job = new Job();
		Employer employer = employerDao.findById(jobbAddRequest.getEmployerId())
				.orElseThrow(() -> new Exception("İşveren bulunamadı"));
		City city = cityDao.findById(jobbAddRequest.getCityId()).orElseThrow(() -> new Exception("Şehir bulunamadı"));

		WorkType workType = workTypeDao.findById(jobbAddRequest.getWorkTypeId())
				.orElseThrow(() -> new Exception("İş tipi bulunamadı"));

		IsActive isActive = isActiveDao.findById(jobbAddRequest.getIsActiveId())
				.orElseThrow(() -> new Exception("Aktiflik durumu bulunamadı"));
		
		
		job.setEmployer(employer);
		job.setCity(city);
		job.setIsActive(isActive);
		job.setWorkType(workType);
		job.setDescription(jobbAddRequest.getDescription());
		job.setMinWage(jobbAddRequest.getMinWage());
		job.setMaxWage(jobbAddRequest.getMaxWage());
		job.setQuota(jobbAddRequest.getQuota());
		job.setApplicationDeadline(jobbAddRequest.getApplicationDeadline());
		jobDao.save(job);
		
		return new SuccessResult("İş ilanı başarıyla eklendi iyi günler " + employer.getCompany_name());
	}

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>
		(this.jobDao.findAll(),"Data listlendi");	
	}

@Override
	public Result setActivateJob(JobCheckRequest jobCheckRequest) throws Exception {	
    		Job job = jobDao.findById(jobCheckRequest.getJobid())
    				.orElseThrow(() -> new Exception("Böyle Bir İş Yok"));
            
    		employerDao.findById(jobCheckRequest.getEmployerId())
    				.orElseThrow(() -> new Exception("İşveren bulunamadı"));
		   
    		IsActive isActive = isActiveDao.findById(jobCheckRequest.getIsActiveid())
    		        .orElseThrow(() -> new Exception("Geçersiz aktiflik durumu"));
    		
    	job.setDescription(jobCheckRequest.getDescription());
    		
    		
    	   job.setIsActive(isActive);
    	   job.setQuota(jobCheckRequest.getQuate());
		   jobDao.save(job);
		
			 if(isActive.getId()==1){
				 return new SuccessResult("İş ilanı yayına alındı alım kotası : "+job.getQuota());
			 } if(isActive.getId()==2) {
				 return new SuccessResult("İş ilanı yayından kaldırıldı ");
			 }
			
			 return new SuccessResult();
}
			 
			 
			public boolean removeJob(int id) {
				jobDao.deleteById(id);
				return true;
			}
	}




