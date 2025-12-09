package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lu.cnfpc.grade_submission.exception.GradeNotFoundException;
import lu.cnfpc.grade_submission.model.Grade;
import lu.cnfpc.grade_submission.repository.GradeRepository;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    //Methods that interact with gradeRepository

    // Get Grade by Id
    public Grade getGradeByID(Long id){
        return gradeRepository.findById(id).orElseThrow(() -> new GradeNotFoundException("Grade not found with id: " + id));
    }

    public void submitGrade(Grade grade){
        gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    public void remove(Long id){
        gradeRepository.deleteById(id);
    }

}
