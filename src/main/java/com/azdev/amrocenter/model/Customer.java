package com.azdev.amrocenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    private String taxCode;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    private List<Bill> bill;

//    @OneToOne
//    @MapsId
//    @JsonIgnore
//    private Bill bill;
}
