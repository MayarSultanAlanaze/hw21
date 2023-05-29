package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.Teacher;
import com.example.demo.Repositry.TeacherRepository;
import com.example.demo.Service.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class ControllerTeacher {
    private final ServiceTeacher serviceTeacher;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        List<Teacher> teacher=serviceTeacher.getAllTeachers();
        return ResponseEntity.status(200).body(teacher);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody  Teacher teacher){
        serviceTeacher.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity  updaTeteacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        serviceTeacher.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        serviceTeacher.DeleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");

    }
}
