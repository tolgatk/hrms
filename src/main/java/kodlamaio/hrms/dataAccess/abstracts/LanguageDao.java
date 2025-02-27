package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrates.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language,Integer> {
    List<Language> findByCandidateId(int candidateId);
    void deleteByCandidateId(int candidateId);
}
