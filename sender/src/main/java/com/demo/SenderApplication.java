package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@EnableBinding(RegisterSource.class)
@RestController
@SpringBootApplication
public class SenderApplication {
    @Autowired
    private RegisterSource registerProcessor;

    @RequestMapping(method = RequestMethod.POST, path = "/send")
    public void write (@RequestBody Map<String, Object> msg){
        registerProcessor.registerSource().send(MessageBuilder.withPayload(msg).build());
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}
