package kodlamaio.hrms.entities.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCheckRequest {
	private int employerId;
	private int jobid;
	private int isActiveid;
	private String description;
	private int quate;
}
