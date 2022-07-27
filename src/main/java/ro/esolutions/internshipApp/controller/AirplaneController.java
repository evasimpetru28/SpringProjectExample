package ro.esolutions.internshipApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.internshipApp.entity.Airplane;
import ro.esolutions.internshipApp.repository.AirplaneRepository;
import ro.esolutions.internshipApp.service.AirplaneService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/airplane")
@RequiredArgsConstructor // lombok; se ia in constructor ca parametrii tot ce definim ca variabile
public class AirplaneController {

    final AirplaneService airplaneService; //Dependency injection
    // injectam repository in controller; o sg data la inceput
    // variabila final trebuie instantiata

    @GetMapping("/dashboard")
    public String getAirplaneDashboard(Model model) {
        model.addAttribute("airplanes", getAirplanesList());
        //model.addAttribute("allAirplanes", airplaneRepository.findAll());
        return "airplane/dashboardView";
    }

    @GetMapping("/info/{id}")
    public String getAirplaneDashboard(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
//        model.addAttribute("airplane", getAirplaneById(id));
        return "airplane/infoView";
    }

    @PostMapping("/add")
    public String saveAirplane(@ModelAttribute Airplane airplane) {
        System.out.println(airplane);
        return "redirect:/airplane/dashboard"; // redirect in controller-ul pe care il doresc
    }

    private List<Airplane> getAirplanesList() {
        return List.of(
                new Airplane(1L, "A", 20),
                new Airplane(2L, "B", 50),
                new Airplane(3L, "C", 33),
                new Airplane(4L, "D", 16)
        );
    }

//    private Airplane getAirplaneById(Long id) {
//        return getAirplanesList()
//                .stream()
//                .filter(a -> a.getId() == id);
//    }

//
//    private List<Airplane> getAirplane(final Long id) {
//        Map<Long, Airplane> map = getAirplanesList()
//                .stream()
//                .collect(Collectors.toMap(), )
//
//    }

}
