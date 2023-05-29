package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Teacher;
import com.example.demo.Repositry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceTeacher {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public void addTeacher
            (Teacher teacher) {
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Teacher teacher, Integer id) {
        Teacher teacher1 = teacherRepository.getById(id);
        if (teacher1 == null) {
            teacher1.setName(teacher.getName());
            teacher1.setAge(teacher.getAge());
            teacher1.setEmail(teacher.getEmail());
            teacher1.setSalary(teacher.getSalary());
            teacherRepository.save(teacher1);
        }
    }
        public void DeleteTeacher(Integer id){
            Teacher teacher2 = teacherRepository.findTeacherById(id);
            if (teacher2 == null) {
                throw new ApiException("not found");
            }
            teacherRepository.delete(teacher2);
        }
}



