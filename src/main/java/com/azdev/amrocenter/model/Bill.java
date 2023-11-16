package com.azdev.amrocenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double totalPrice;

    private String paymentMethod;

    private String description;

    private double discount;

    private LocalDate date;




    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<Parts> part;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<Maintenance> maintenance;

}