package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lu.cnfpc.grade_submission.model.Course;
import lu.cnfpc.grade_submission.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }
    
}
