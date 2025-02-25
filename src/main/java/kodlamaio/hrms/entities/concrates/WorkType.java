package kodlamaio.hrms.entities.concrates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="worktypes")
@AllArgsConstructor
@NoArgsConstructor
public class WorkType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//burda worktype managerde kullanıcının candidate yada employer olup olmadığını anlamak için böyle yaptım
	//normalde private Integer user_id; idi int değilde neden Integer(cünkü null kontrolü yapabilmek için)
	//@ManyToOne
	//@JoinColumn(name="user_id")
	//private Employer employer ;
	
	private int user_id;
	@Column(name = "work_name", unique = true)  // unique constraint eklendi
	private String workName;
	@Column(name = "work_description")
	private String workDescription;
	
}
