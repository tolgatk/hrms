package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkAddRequest {
	private Integer user_id;
	private String work_name;
	private String work_description;

}
