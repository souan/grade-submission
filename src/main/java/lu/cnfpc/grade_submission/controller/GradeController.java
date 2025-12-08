package lu.cnfpc.grade_submission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lu.cnfpc.grade_submission.model.Grade;
import lu.cnfpc.grade_submission.repository.GradeRepository;
import lu.cnfpc.grade_submission.service.GradeService;

@Controller
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService  = gradeService;
    }


    // Get me the form for the root path/route /
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        // pass the new or existing student grade object to the model
        model.addAttribute("grade", gradeService.getGradeByID(id));
        return "form";
    }

    //Handler method to handle the Grade submitted by the HTML Form
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        // add a new grade if it doesn't already exist
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    //handler method getGrades
    public String getGrades(Model model) {
        //add data to the model
        model.addAttribute("grades", gradeService.getAllGrades());
        return "grades";
    }




    
    
}
