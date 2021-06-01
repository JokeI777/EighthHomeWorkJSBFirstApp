package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class TransferRMQService {

    @Autowired
    StreamBridge streamBridge;

    public void send(MessageToRMQ messageToRMQ){
        streamBridge.send("toStream-out-0",  messageToRMQ);
    }

}
