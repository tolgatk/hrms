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
@Table(name="isactives")
@AllArgsConstructor
@NoArgsConstructor
public class IsActive {
	@Id
	  @Column(name = "id")
	private int id;
	  @Column(name = "is_active")
	private boolean is_active;

}
