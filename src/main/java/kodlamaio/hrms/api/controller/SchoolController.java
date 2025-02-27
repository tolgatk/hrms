package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concrates.School;
import kodlamaio.hrms.entities.dto.SchoolAddRequset;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/School")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/add")
    Result add (@RequestBody SchoolAddRequset schoolAddRequset){
      return schoolService.add(schoolAddRequset);
    }
    @DeleteMapping("/delete")
    Result deleteByUserId(@RequestParam int userid){
        return schoolService.deleteByUserId(userid);
    }
    @GetMapping("/getByUserId")
    DataResult<List<School>> getByUserId(@RequestParam int userid){
        return schoolService.getByUserId(userid);
    }

}
