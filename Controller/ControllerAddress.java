package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.DTO.AddressDTO;
import com.example.demo.Model.Address;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.ServiceAddress;
import com.example.demo.Service.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class ControllerAddress {
    private final ServiceAddress serviceAddress;



    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        serviceAddress.addDetails(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
       serviceAddress.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("address Updated");
    }
}
