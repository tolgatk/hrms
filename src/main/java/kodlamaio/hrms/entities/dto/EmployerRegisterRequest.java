package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterRequest {
	
	private String email;
	private String password;
	private String vergino;
	private String company_name;

}
