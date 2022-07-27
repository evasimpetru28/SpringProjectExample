package ro.esolutions.internshipApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airplane")
public class AirplaneController {

    @GetMapping("/dashboard")
    public String getAirplaneDashboard(Model model) {

        return "airplane/dashboardView";
    }

}
