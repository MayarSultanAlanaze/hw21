package com.example.demo.Repositry;

import com.example.demo.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryCourse extends JpaRepository<Course,String> {

    Course findCourseById(Integer id);
    Course getCourseByName(String name);

}
