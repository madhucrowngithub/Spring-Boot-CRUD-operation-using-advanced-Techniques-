package com.myproject.jpademo.core.dto;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Data
public class EventQueueDto {

    int id;
    String eventKey;
    String eventMessage;
    String token;

    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
