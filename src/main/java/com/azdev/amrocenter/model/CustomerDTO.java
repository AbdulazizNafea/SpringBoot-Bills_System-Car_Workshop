package com.azdev.amrocenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;

    private String name;

    private String phone;

    private String taxCode;
}
