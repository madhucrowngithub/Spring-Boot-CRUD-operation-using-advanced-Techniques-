package com.myproject.jpademo.core.dto;


import lombok.Data;

@Data
public class CreateProductDto {

    private int id;
    private String name;
    private String serialNumber;

}
