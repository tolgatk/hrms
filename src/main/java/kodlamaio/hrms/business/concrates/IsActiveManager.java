package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IsActiveService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.IsActiveDao;
import kodlamaio.hrms.entities.concrates.IsActive;
import kodlamaio.hrms.entities.dto.IsActiveControllRequest;
import lombok.Data;

@Data
@Service
public class IsActiveManager implements IsActiveService {
	
	private IsActiveDao activeDao;
	@Autowired
	public IsActiveManager(IsActiveDao activeDao) {
		super();
		this.activeDao = activeDao;
	}
	
	@Override
	public Result isActiveRequest(IsActiveControllRequest activeControllRequest) {
		IsActive active = new IsActive();
		active.set_active(activeControllRequest.is_active());
		activeDao.save(active);
		return new SuccessResult("Aktifliği başarı ile güncellediniz ");
	}

//	@Override
//	public Result getIsActive(IsActiveControllRequest activeControllRequest) {
//		IsActive active = new IsActive();
//		active.setId(activeControllRequest.getId());
//		
//		if(active.getId()==1) {
//			new ErrorDataResult<>("False");
//		}
//		
//		return  new SuccessResult("True");
//	}



	

}
