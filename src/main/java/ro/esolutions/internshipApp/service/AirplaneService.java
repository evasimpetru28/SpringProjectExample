package ro.esolutions.internshipApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.internshipApp.repository.AirplaneRepository;


@Service
@RequiredArgsConstructor
public class AirplaneService {

    final AirplaneRepository airplaneRepository;

    // aici comunicam cu baza de date
    // punem metode si alteram stream-uri

}
