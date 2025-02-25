package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concrates.WorkType;



public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{
//bunu kullanıcı iş ismi yani (java c#) eklediğinde iş varmı diye kontrol ediyor
	@Query("SELECT CASE WHEN COUNT(w) > 0 THEN true ELSE false END FROM WorkType w WHERE LOWER(w.workName) = LOWER(:workName)")
	 boolean existsByWorkName(String workName);

}
