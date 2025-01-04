package com.myproject.jpademo.services;

public interface KafkaProducerService {

    public void sendMessage(String key,String msg);

}
