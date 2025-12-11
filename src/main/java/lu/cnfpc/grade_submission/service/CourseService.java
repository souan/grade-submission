package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lu.cnfpc.grade_submission.model.Course;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.repository.CourseRepository;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Get students enrolled in a course
    public List<Student> getStudentsInCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        return course.getStudents();
    }
    
}
