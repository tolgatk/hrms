package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concrates.Language;
import kodlamaio.hrms.entities.dto.LanguageAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/getUserById")
    public DataResult<List<Language>> getByUserId(@RequestParam int userId) {
        return languageService.getByUserId(userId);
    }

    @PostMapping("/add")
    public Result add(LanguageAddRequest languageAddRequest){
        return languageService.add(languageAddRequest);
    }
    @DeleteMapping("/delete")
    public Result deleteByUserId(@RequestParam int userId) {
        return languageService.deleteByUserId(userId);
    }
}
