package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByEmail(String email);
	void deleteImageById(int id);

}
