package lu.cnfpc.grade_submission.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lu.cnfpc.grade_submission.model.Course;
import lu.cnfpc.grade_submission.service.CourseService;
import lu.cnfpc.grade_submission.service.StudentService;


@Controller
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService){
        this.courseService = courseService;
        this.studentService = studentService;
    }
    
    @GetMapping("/courses")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);
        return "courses";
    }

    // Get the form to add a new course
    @GetMapping("/addcourse")
    public String getCourseForm(Model model, @RequestParam(required = false) Long courseId) {
        Course course = (courseId != null) ? courseService.getCourseById(courseId) : new Course();
        model.addAttribute("course", course);
        return "add_course";
    }

    // Handle course form submission
    @PostMapping("/courseSubmit")
    public String submitCourse(@Valid Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_course";
        }
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    // Delete a course
    @GetMapping("/delete-course")
    public String deleteCourse(@RequestParam Long courseId, RedirectAttributes redirectAttributes) {
        courseService.deleteCourse(courseId);
        redirectAttributes.addFlashAttribute("message", "Course deleted successfully!");
        return "redirect:/courses";
    }

    // View course details with enrolled students
    @GetMapping("/course-details")
    public String getCourseDetails(@RequestParam Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        model.addAttribute("enrolledStudents", course.getStudents());
        model.addAttribute("availableStudents", studentService.getStudents());
        return "course_details";
    }
    
}
