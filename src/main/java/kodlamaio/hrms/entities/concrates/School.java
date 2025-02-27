package kodlamaio.hrms.entities.concrates;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Candidate candidate;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String  department;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;


}
