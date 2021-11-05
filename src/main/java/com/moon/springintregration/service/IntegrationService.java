package com.moon.springintregration.service;


import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegrationService {




    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage(Message<String> message)throws MessagingException{

        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload("Welcome" + message.getPayload()+ "to Spring integration").build();
        replyChannel.send(newMessage);


    }


}
