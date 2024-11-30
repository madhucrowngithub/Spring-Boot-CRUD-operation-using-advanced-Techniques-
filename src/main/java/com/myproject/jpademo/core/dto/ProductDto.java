package com.myproject.jpademo.core.dto;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Data
public class ProductDto {

    private int id;
    private String name;
    private String serialNumber;
    private String token;

    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
