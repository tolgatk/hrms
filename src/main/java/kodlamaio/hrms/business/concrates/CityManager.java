package kodlamaio.hrms.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concrates.City;
import kodlamaio.hrms.entities.dto.CityAddRequest;
import lombok.Data;

@Data
@Service
public class CityManager implements CityService{
	
private	CityDao cityDao;

@Autowired
public CityManager(CityDao cityDao) {
	super();
	this.cityDao = cityDao;
}

@Override
public Result cityAdd(CityAddRequest cityAddRequest) {
	City city = new City();
	city.setSehir_ad(cityAddRequest.getSehir_ad());

	cityDao.save(city);
	return new SuccessResult("Şehir başarı ile eklendi : " + cityAddRequest.getSehir_ad());
} 


	
	
}
