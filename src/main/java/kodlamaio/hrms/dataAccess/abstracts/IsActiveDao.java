package kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrates.IsActive;
public interface IsActiveDao extends JpaRepository<IsActive, Integer> {
	
	
}
