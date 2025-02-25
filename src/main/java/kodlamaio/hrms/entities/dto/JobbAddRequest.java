package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobbAddRequest {
	//sadece employer
	  private int employerId;
	  private int cityId;
	  private int workTypeId;
	  private int isActiveId;
	  private String description;
	  private int quota;
	  private String minWage;
	  private String maxWage;
	  private String applicationDeadline;
	  
	  
	  
	  
	  
	  
	}
	
	


