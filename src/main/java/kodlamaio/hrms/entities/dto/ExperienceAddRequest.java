package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceAddRequest {
	
	private int userid;
	private String companyName;
	private String position;
	private int startYear;
	private int endYear;

}
