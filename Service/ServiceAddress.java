package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.DTO.AddressDTO;
import com.example.demo.Model.Address;
import com.example.demo.Model.Teacher;
import com.example.demo.Repositry.RepositoryAddress;
import com.example.demo.Repositry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceAddress {

    private final RepositoryAddress repositoryAddress;
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addDetails(AddressDTO dto) {
        Teacher teacher=teacherRepository.findTeacherById(dto.getAddress_id());
        if (teacher==null){
            throw new ApiException("not found");
        }
        Address address=new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);
        repositoryAddress.save(address);
    }

    public void updateAddress(AddressDTO dto) {
        Teacher teacher1= teacherRepository.findTeacherById(dto.getAddress_id());
        if (teacher1 == null) {
            throw new ApiException("not found");
        }
           Address address= repositoryAddress.findAddressById(dto.getAddress_id());
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        repositoryAddress.save(address);

    }

    }

