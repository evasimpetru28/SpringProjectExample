package ro.esolutions.internshipApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.internshipApp.entity.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {


}
