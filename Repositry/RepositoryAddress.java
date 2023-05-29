package com.example.demo.Repositry;

import com.example.demo.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAddress extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
// RepositoryAddressressByBuildingNumber(Integer buildingNumber);

}
