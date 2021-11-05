package com.moon.springintregration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.springintregration.model.Address;
import com.moon.springintregration.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {



    @Bean
    public MessageChannel recieverChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }


    @Bean
    @Transformer(inputChannel = "integration.student.gateway.channel",outputChannel = "integration.student.objectToJson.channel")
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());

    }
    @Bean
    public Jackson2JsonObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(mapper);
    }
    @Bean
    @Transformer(inputChannel = "integration.student.jsonToObject.channel",outputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Student.class);
    }


    @ServiceActivator(inputChannel = "router.channel")
    @Bean
    public PayloadTypeRouter router(){
        PayloadTypeRouter router = new PayloadTypeRouter();
        router.setChannelMapping(Address.class.getName(),"address.channel");
        return router;
    }

}
