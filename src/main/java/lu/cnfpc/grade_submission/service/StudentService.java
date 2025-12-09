package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lu.cnfpc.grade_submission.exception.StudentNotFoundException;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        
}
