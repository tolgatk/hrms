package kodlamaio.hrms.entities.concrates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")

public class Candidate extends User{
	
	@Column(name = "img_url")
	private String imgUrl;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;

	@Column(name ="tckimlik_no")
	private String tckimlik_no;
	
}
