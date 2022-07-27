package ro.esolutions.internshipApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.internshipApp.entity.Dog;

import java.util.List;

public class DogRepo extends JpaRepository<Dog, Long> {
//    List<Dog> getDogsByName();
}
