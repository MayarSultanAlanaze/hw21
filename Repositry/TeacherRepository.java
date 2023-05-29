package com.example.demo.Repositry;

import com.example.demo.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);
   // Teacher getTeachersByName(String name);

}
