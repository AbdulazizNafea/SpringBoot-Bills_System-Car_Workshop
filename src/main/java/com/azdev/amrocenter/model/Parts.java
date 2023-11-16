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
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partName;

    private double price;

    @ManyToOne
    @JoinColumn(name = "bill_id" , referencedColumnName = "id")
    @JsonIgnore
    private Bill bill;
}
