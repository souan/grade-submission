package lu.cnfpc.grade_submission.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lu.cnfpc.grade_submission.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{
    //Method to retrieve all grades for given student
    List<Grade> findByStudentStudentId(Long studentId);
} 