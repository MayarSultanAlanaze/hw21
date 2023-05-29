package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table
public class Address {
    @Id
   private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String Area;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String Street;

    @NotNull
    @Column(columnDefinition = "int default 0")
    private String buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

 }

