package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.Experience;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
    List<Experience> findByCandidateId(int candidateId);
    void deleteByCandidateId(int candidateId);
}
