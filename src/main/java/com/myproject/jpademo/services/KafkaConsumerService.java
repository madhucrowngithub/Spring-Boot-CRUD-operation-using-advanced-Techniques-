package com.myproject.jpademo.services;

public interface KafkaConsumerService {

    public void listen(String key,String msg);
}
