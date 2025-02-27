package kodlamaio.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAddRequset {

    private int userid;
    private String name;
    private String  department;
    private int startYear;
    private int endYear;


}
