package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.CityAddRequest;

@RestController
@RequestMapping("/api/citys")
public class CityController {
private CityService cityService;
@Autowired
public CityController(CityService cityService) {
	super();
	this.cityService = cityService;
	
}
@PostMapping("/addCitiy")
Result cityAdd(@RequestBody CityAddRequest cityAddRequest){
	return this.cityService.cityAdd(cityAddRequest);
	
	
}


}
