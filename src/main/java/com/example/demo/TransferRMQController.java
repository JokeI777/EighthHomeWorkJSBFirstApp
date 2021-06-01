package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TransferRMQController {

    final Logger logger = LoggerFactory.getLogger("HttpMessageSent?");
    private final MessagesFromSecondAppRepository messagesFromSecondAppRepository;
    @Autowired
    TransferRMQService transferRMQService;

    public TransferRMQController(MessagesFromSecondAppRepository messagesFromSecondAppRepository){
        this.messagesFromSecondAppRepository = messagesFromSecondAppRepository;
    }
    @PostMapping("/requests")
    public void requestController(@RequestBody RequestModel requestModel){
        var messageToRMQ = new MessageToRMQ(777, requestModel.getName(),
                requestModel.getPhoneNumber());
        transferRMQService.send(messageToRMQ);
    }

    @GetMapping("/getAnswer")
    public List<HttpAnswers> getAnswers(){

        logger.info("Yes");
        List<HttpAnswers> answers = new ArrayList<>();

        messagesFromSecondAppRepository.findAll()
                .forEach(answers::add);
        return answers;
    }
}
