package lu.cnfpc.grade_submission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    //ArrayList of grade POJO objects, will be replaced by Database later
    List<Grade> studentGrades = new ArrayList<>(Arrays.asList(
        new Grade("Victor","Mathematics","15"),
        new Grade("Bernard","German","10"),
        new Grade("Jean","French","9")
    ));

    /*
    Helper Function to find corresponding index.
     */
    public Integer getGradeIndex(String name){
        for (int i = 0; i < studentGrades.size(); i++){
            if(studentGrades.get(i).getName().equals(name)){
                return i;
            }
        }
        //if not found return a number that identifies a not found (eg. negative integer)
        return -1;
    }

    // Get me the form for the root path/route /
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name) {
        // pass the new or existing student grade object to the model
        model.addAttribute("grade", getGradeIndex(name) == -1 ? new Grade() : studentGrades.get(getGradeIndex(name)));
        return "form";
    }

    //Handler method to handle the Grade submitted by the HTML Form
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        // add a new grade if it doesn't already exist
        if(getGradeIndex(grade.getName()) == -1){
            studentGrades.add(grade);
        }else{
            studentGrades.set(getGradeIndex(grade.getName()), grade);
        }
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
