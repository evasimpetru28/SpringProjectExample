package ro.esolutions.internshipApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.esolutions.internshipApp.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student") // se propaga pe toate request-urilor
public class StudentController {

    // Request din browser ---> Controller
    // return String -> denumirea view html

    //end point
    @GetMapping("/dashboard") // "/myapp/student/dashboard"
    public String getDashboard(Model model) {
        model.addAttribute("firstStudent", "Ion Popescu"); // cheie - valoare
        model.addAttribute("ploua", getRandomBoolean());
        model.addAttribute("result", sum(2,3));

        // for:
        model.addAttribute("names", List.of("Ana", "Mihai", "ALex"));
        model.addAttribute("numbers", List.of(100,200,300,400));
        model.addAttribute("studenti", getAllStudents());
        model.addAttribute("oldStudenti", getOldStudents());

        return "student/dashboardView"; // fara .html, dar vezi in application.properties configurarea pentru mustache
    }

    // end point
    @GetMapping("/info/{id}") // {id} -> PathVariable -> automat detectat in html acum
    public String getInfo(Model model, @PathVariable Integer id) {
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(22,"Andreea", List.of(10,10,9,8,10)));
        map.put(2, new Student(21,"Andrei", List.of(10,10,9,8,10)));
        map.put(3, new Student(20,"Diana", List.of(10,10,9,8,10)));
        model.addAttribute("student", map.get(id));

        return "student/infoView";
    }

    // studentul are mai multe pisici si vrem info despre fiecare
    @GetMapping("/cat")
    public String getCatInfo(Model model, @RequestParam String name,
                             @RequestParam String color) {
        model.addAttribute("name", name);
        model.addAttribute("color", color);
        return "student/catView";
    }

    private List<Student> getOldStudents() {
        return getAllStudents().stream()
                .filter(s -> s.getAge() >= 21)
                .collect(Collectors.toList());
    }
    private List<Student> getAllStudents() {
        return List.of(
                new Student(20, "Ana", List.of(10,8,9,10,7)),
                new Student(22, "Maria", List.of(6,9,10,6,7)),
                new Student(20, "Eva", List.of(8,8,9,10,7))
        );
    }
    private int sum(int x, int y) {
        return x + y;
    }

    private boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }

}
