package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerSecondApp {

    private final MessagesFromSecondAppRepository messagesFromSecondAppRepository;
    final Logger logger = LoggerFactory.getLogger("AnswerFromSecondApp");


    public ConsumerSecondApp(MessagesFromSecondAppRepository messagesFromSecondAppRepository){
        this.messagesFromSecondAppRepository = messagesFromSecondAppRepository;
    }


    @Bean
    public Consumer<MessageFromSecondApp> provide() {
        return answer -> {
            logger.info("received!!");
            var answers = new HttpAnswers();
            answers.setId(answer.getId());
            answers.setTime(answer.getTime());
            answers.setState(answer.getState());
            answers.setMessage(answer.getMessage());
            messagesFromSecondAppRepository.save(answers);
        };
    }

}
