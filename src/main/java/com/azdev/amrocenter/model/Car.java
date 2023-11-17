//package com.azdev.amrocenter.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Car {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String carName;
//
//    private String model;
//
//    private String plateNumber;
//
//    private String carNumber;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Customer customer;
//
//}
