package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer Address_id;
    private String Area;
    private String Street;
    private String buildingNumber;
}
