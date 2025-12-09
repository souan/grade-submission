package lu.cnfpc.grade_submission.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lu.cnfpc.grade_submission.model.Course;
import lu.cnfpc.grade_submission.service.CourseService;


@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService  = courseService;

    }
    
    @GetMapping("/courses")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);
        return "courses";
    }
    
}
