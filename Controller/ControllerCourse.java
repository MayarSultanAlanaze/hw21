package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.DTO.AddressDTO;
import com.example.demo.DTO.CourseDTO;
import com.example.demo.Service.ServiceCourse;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class ControllerCourse {
    private  final ServiceCourse serviceCourse;

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody CourseDTO courseDTO){
        serviceCourse.addDetails(courseDTO);
        return ResponseEntity.status(200).body(new ApiResponse("course added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateCourse(@Valid @RequestBody CourseDTO courseDTO){
        return ResponseEntity.status(200).body("course Updated");
    }
    @PutMapping("/{Course_name}/assign/{teacher_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable String Course_name){
        serviceCourse.assignTeacherToCourse(teacher_id,Course_name);
        return ResponseEntity.status(200).body("Assign done");

    }
}
