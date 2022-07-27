package ro.esolutions.internshipApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor // Lombok
@NoArgsConstructor
public class Student {
    private Integer age;
    private String name;
    private List<Integer> marks;
}
