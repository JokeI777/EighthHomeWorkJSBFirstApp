package com.example.demo;

public class MessageToRMQ {
    private final Integer id;
    private final String name;
    private final String phoneNumber;

    public MessageToRMQ(Integer id, String name, String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
