package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lu.cnfpc.grade_submission.model.Grade;
import lu.cnfpc.grade_submission.model.Student;
import lu.cnfpc.grade_submission.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentrepo;

    public StudentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }

    /*
        Helper Function to find corresponding index.
    */
    private Integer getStudentIndex(String id){
        for (int i = 0; i < studentrepo.getAll().size(); i++){
            if(studentrepo.getOne(i).getStudentId().equals(id)){
                return i;
            }
        }
        //if not found return a number that identifies a not found (eg. negative integer)
        return -1;
    }


    public Student getStudentById(String id){
        return studentrepo.getOne(getStudentIndex(id));
    }

    public List<Student> getAllStudents(){
        return studentrepo.getAll();
    }

    





    
}
