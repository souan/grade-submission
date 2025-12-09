package lu.cnfpc.grade_submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lu.cnfpc.grade_submission.model.Grade;
import lu.cnfpc.grade_submission.service.CourseService;
import lu.cnfpc.grade_submission.service.GradeService;
import lu.cnfpc.grade_submission.service.StudentService;

@Controller
public class GradeController {

    private final CourseService courseService;
    private final GradeService gradeService;
    private final StudentService studentService;

    public GradeController(GradeService gradeService, StudentService studentService, CourseService courseService){
        this.gradeService  = gradeService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Get me the form for the root path/route /
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) Long id) {
        //Create new grade or get existing one
        Grade grade = (id != null) ? gradeService.getGradeByID(id) : new Grade();

        // pass the new or existing student grade object to the model
        model.addAttribute("grade", grade);
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("courses", courseService.getAll());
        return "form";
    }

    //Handler method to handle the Grade submitted by the HTML Form
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
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

    @GetMapping("/delete")
    public String deleteGrade(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        gradeService.remove(id);
        redirectAttributes.addFlashAttribute("message","Grade deleted");
        return "redirect:/grades";
    }
    
}
