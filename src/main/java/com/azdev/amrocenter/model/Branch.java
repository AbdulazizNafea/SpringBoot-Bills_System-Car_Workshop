package com.azdev.amrocenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String branchName;

    private String commercialRecord;

    private String locationDetails;

    private String googleAddress;

    private String phone;

    private String phone2;

    private String email;

    private String bankName;

    private String IBAN;

}
