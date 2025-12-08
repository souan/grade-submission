package lu.cnfpc.grade_submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // A handler method that handles the form submit of a Student
    @PostMapping("/studentSubmit")
    public String submitStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        studentService.submitStudent(student);
        return "redirect:/students";
    }

    // A handler method to get the student form
    @GetMapping("/addstudent")
    public String getStudentForm(Model model, @RequestParam(required = false) String studentId) {
        model.addAttribute("student",studentService.getStudentbyId(studentId));
        return "add_student";
    }

    // A handle  method to get the student list
    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    // A handler method that handles a delete student request
    @GetMapping("/delete-student")
    public String getMethodName(@RequestParam String studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    } 
}
