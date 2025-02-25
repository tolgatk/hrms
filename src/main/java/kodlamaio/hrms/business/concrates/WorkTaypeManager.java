package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;

import kodlamaio.hrms.entities.concrates.WorkType;
import kodlamaio.hrms.entities.dto.WorkAddRequest;
import lombok.Data;

@Data
@Service
public class WorkTaypeManager implements WorkTypeService {
	
	
	private final WorkTypeDao workTypeDao;
	//private final EmployerDao employerDao;
	
	//mecburen 2 sini aynı yerde almak zorunda kaldım
//@Autowired
//	public WorkTaypeManager(WorkTypeDao workTypeDao, EmployerDao employerDao) {
//		super();
//		this.workTypeDao = workTypeDao;
//		this.employerDao = employerDao;
//	}
//	
	@Autowired
	public WorkTaypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}
	
//	
//	@Override
//	public Result workTaypeAdd(WorkAddRequest workAddRequest) {
//		WorkType workType =new WorkType();
//	
//		//eski hali
//		if(workAddRequest.getUser_id() == null) {
//			return new ErrorDataResult<>("İşveren girişi yapmadan ve iş ekleyemezsiniz (Aday pozisyonundasınız)");
//			}
////		  Employer employer = employerDao.findById(workAddRequest.getUser_id()).orElse(null);
////		  if (employer == null) {
////	            return new ErrorDataResult<>("Bu ID'ye sahip işveren bulunamadı!");
////	        }
//		  // İş adı boş mu kontrolü
//	        if(workAddRequest.getWork_name() == null || workAddRequest.getWork_name().trim().isEmpty()) {
//	            return new ErrorDataResult<>("İş adı girmek zorundasınız");
//	        }
//	        
//	        // Bu iş zaten var mı kontrolü
//	        if(workTypeDao.existsByWorkName(workAddRequest.getWork_name())) {
//	            return new ErrorDataResult<>("Bu iş adı zaten mevcut!");
//	        }
//		if(workAddRequest.getWork_description().trim().isEmpty()) {
//			return new ErrorDataResult<>("iş açıklaması boş olamaz");
//		}
//		if(workAddRequest.getWork_name().trim().isEmpty()) {
//			return new ErrorDataResult<>("İş adı girmek zorundasınız");
//		}
//		
//		//workType.setUser_id(workAddRequest.getUser_id()); 
//		workType.setUser_id(workAddRequest.getUser_id());
//		workType.setWorkName(workAddRequest.getWork_name());
//		workType.setWorkDescription(workAddRequest.getWork_description());
//		this.workTypeDao.save(workType);
//		return new SuccessResult("Başarılı bir şekilde iş eklediniz: "+ workAddRequest.getWork_name());
//	}
//	//try catch kullanımını pekiştir
	@Override
	public Result workTaypeAdd(WorkAddRequest workAddRequest) {
	    try {
	        WorkType workType = new WorkType();
	        
	        // Candidate kontrolü
	        if(workAddRequest.getUser_id() == null) {
	            return new ErrorDataResult<>("İşveren girişi yapmadan iş ekleyemezsiniz (Aday pozisyonundasınız)");
	        }
	        
	        // İş adı kontrolü
	        if(workAddRequest.getWork_name() == null || workAddRequest.getWork_name().trim().isEmpty()) {
	            return new ErrorDataResult<>("İş adı girmek zorundasınız");
	        }
	        
	        // İş açıklaması kontrolü
	        if(workAddRequest.getWork_description() == null || workAddRequest.getWork_description().trim().isEmpty()) {
	            return new ErrorDataResult<>("İş açıklaması boş olamaz");
	        }
	        
	        // Aynı isimde iş var mı kontrolü //kullanımını bilmiyorum workAddRequest.getWork_name().trim() ve existsByWorkName
	        if(workTypeDao.existsByWorkName(workAddRequest.getWork_name().trim())) {
	            return new ErrorDataResult<>("Bu iş adı zaten mevcut!");
	        }
	        
	        // Değerleri atama
	        workType.setUser_id(workAddRequest.getUser_id());
	        workType.setWorkName(workAddRequest.getWork_name().trim());
	        workType.setWorkDescription(workAddRequest.getWork_description().trim());
	        
	        this.workTypeDao.save(workType);
	        return new SuccessResult("Başarılı bir şekilde iş eklediniz: " + workType.getWorkName());
	        
	    } catch (Exception e) {
	        return new ErrorDataResult<>("İş eklenirken bir hata oluştu: " + e.getMessage());
	    }
	}








	










	
}
