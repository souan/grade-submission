package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lu.cnfpc.grade_submission.exception.StudentNotFoundException;
import lu.cnfpc.grade_submission.model.Course;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.repository.CourseRepository;
import lu.cnfpc.grade_submission.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student getStudentbyId(Long student_id){
        return studentRepository.findById(student_id)
        .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + student_id));
    }

    public void submitStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    // service to delete student by id
    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }

    // Enroll a student in a course
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        
        student.addCourse(course);
        studentRepository.save(student);
    }

    // Unenroll a student from a course
    public void unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        
        student.removeCourse(course);
        studentRepository.save(student);
    }

    // Get courses for a student
    public List<Course> getCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));
        return student.getCourses();
    }
        
}
