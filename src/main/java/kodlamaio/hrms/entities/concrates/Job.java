package kodlamaio.hrms.entities.concrates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobpostings")
@AllArgsConstructor
@NoArgsConstructor

public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 	@ManyToOne
	    @JoinColumn(name = "user_id")
	    private Employer employer;
	    
	    @ManyToOne
	    @JoinColumn(name = "city_id")
	    private City city;
	    
	    @ManyToOne
	    @JoinColumn(name = "work_type_id")
	    private WorkType workType;
	    
	    @ManyToOne
	    @JoinColumn(name = "is_active_id")
	    private IsActive isActive;
	    
	    @Column(name = "description")
	    private String description;
	    
	    @Column(name = "quota")
	    private int quota;
	    
	    @Column(name = "min_wage")
	    private String minWage;
	    
	    @Column(name = "max_wage")
	    private String maxWage;
	    
	    @Column(name = "application_deadline")
	    private String applicationDeadline;

}
