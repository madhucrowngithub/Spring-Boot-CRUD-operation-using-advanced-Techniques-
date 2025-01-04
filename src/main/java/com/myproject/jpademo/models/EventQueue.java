package com.myproject.jpademo.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "event_queue")
public class EventQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String eventKey;
    String eventMessage;
    String token;
}
