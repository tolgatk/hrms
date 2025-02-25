package kodlamaio.hrms.entities.concrates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Candidate candidate;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;

	@Column(name="start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;
}
