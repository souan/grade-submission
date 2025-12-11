package lu.cnfpc.grade_submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.service.CourseService;
import lu.cnfpc.grade_submission.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
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
    public String getStudentForm(Model model, @RequestParam(required = false) Long studentId) {

        Student student = (studentId != null) ? studentService.getStudentbyId(studentId) : new Student();
        
        model.addAttribute("student", student);
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
    public String getMethodName(@RequestParam Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    // View student details with enrolled courses
    @GetMapping("/student-details")
    public String getStudentDetails(@RequestParam Long studentId, Model model) {
        Student student = studentService.getStudentbyId(studentId);
        model.addAttribute("student", student);
        model.addAttribute("enrolledCourses", student.getCourses());
        model.addAttribute("availableCourses", courseService.getAll());
        return "student_details";
    }

    // Enroll student in a course
    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId, RedirectAttributes redirectAttributes) {
        studentService.enrollStudentInCourse(studentId, courseId);
        redirectAttributes.addFlashAttribute("message", "Student enrolled successfully!");
        return "redirect:/student-details?studentId=" + studentId;
    }

    // Unenroll student from a course
    @GetMapping("/unenroll")
    public String unenrollStudent(@RequestParam Long studentId, @RequestParam Long courseId, RedirectAttributes redirectAttributes) {
        studentService.unenrollStudentFromCourse(studentId, courseId);
        redirectAttributes.addFlashAttribute("message", "Student unenrolled successfully!");
        return "redirect:/student-details?studentId=" + studentId;
    }
}
