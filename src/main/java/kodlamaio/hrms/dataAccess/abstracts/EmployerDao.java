package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findByEmail(String email);

}
