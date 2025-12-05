package lu.cnfpc.grade_submission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class GradeController {

    //ArrayList of grade POJO objects
    List<Grade> studentGrades = new ArrayList<>(Arrays.asList(
        new Grade("Victor","Mathematics","15"),
        new Grade("Bernard","German","10"),
        new Grade("Jean","French","9")
    ));

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    //handler method to handle the Grade sent by the HTML Form
    @PostMapping("/handleSubmit")
    public String saveGrade(Grade grade) { 
        //handle the DATA 
        studentGrades.add(grade);
        //if everything goes well
        return "redirect:/grades";
    }
    
    

    @GetMapping("/grades")
    //handler method getGrades
    public String getGrades(Model model) {
        //add data to the model
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    
    
}
