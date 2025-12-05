package lu.cnfpc.grade_submission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {

    //ArrayList of grade POJO objects
    List<Grade> studentGrades = Arrays.asList(
        new Grade("Victor","Mathematics","15"),
        new Grade("Bernard","German","10"),
        new Grade("Jean","French","9")
    );

    @GetMapping("/grades")
    //handler method getGrades
    public String getGrades(Model model) {
        //add data to the model
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    
    
}
