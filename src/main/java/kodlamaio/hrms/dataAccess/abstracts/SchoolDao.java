package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrates.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository <School,Integer> {
    List<School> findByCandidateId(int candidateId);
    void deleteByCandidateId(int candidateId);
}
