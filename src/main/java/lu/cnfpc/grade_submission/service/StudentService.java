package lu.cnfpc.grade_submission.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentbyId(String student_id){
        Student student;
        // if the ID isn't found in the ArrayList, means a new student!
        if(getStudentIndex(student_id) == -1){
            // then create new student object
            student = new Student();
        }else{
            student = studentRepository.getStudent(getStudentIndex(student_id));
        }
        return student;
    }

    // Helper function to find index of a student grade
    public Integer getStudentIndex(String id){
        for(int i = 0; i < studentRepository.getStudents().size() ; i++){
            if(studentRepository.getStudent(i).getStudentId().equals(id)){
                return i;
            }
        }
        //if not found return a negative integer
        return -1;
    }

    public void submitStudent(Student student){
        //business logic for adding or updating a student
        if(getStudentIndex(student.getStudentId()) == -1){
            // adding  student to the students ArrayList
            studentRepository.addStudent(student);
        }else{
            // updating
            studentRepository.updateStudent(student, getStudentIndex(student.getStudentId()));
        }
    }

    public ArrayList<Student> getStudents(){
        return studentRepository.getStudents();
    }

    // service to delete student by id
    public void deleteStudent(String studentId){
        studentRepository.removeStudent(getStudentbyId(studentId));
    }
        
}
