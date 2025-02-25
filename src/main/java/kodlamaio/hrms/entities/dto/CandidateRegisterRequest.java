package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRegisterRequest {
	

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String tckimlik_no;
}
