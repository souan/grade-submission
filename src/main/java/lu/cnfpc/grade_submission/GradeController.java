package lu.cnfpc.grade_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {

    @GetMapping("/grades")
    //handler method getGrades
    public String getGrades(Model model) {
        Grade grade = new Grade("Victor","Mathematics","15");
        //add data to the model
        model.addAttribute("grade", grade);
        return "grades";
    }

    
    
}
