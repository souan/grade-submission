package lu.cnfpc.grade_submission.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import lu.cnfpc.grade_submission.model.Student;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>(Arrays.asList(
        new Student("Victor","Dupond"),
        new Student("Joe","Doe")
    ));

    public List<Student> getAll(){
        return students;
    }

    public Student getOne(int index){
        return students.get(index);
    }
    
}
