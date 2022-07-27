package ro.esolutions.internshipApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "my_airplane")
public class Airplane {
    @Id
    @Column(name="id") //
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String  name;

    @Column
    private Integer age;
}
