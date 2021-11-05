package com.moon.springintregration.service;


import com.moon.springintregration.model.Student;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
@Component
public interface IntegrationGateway {

    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendMessage(String message);

    @Gateway(requestChannel = "integration.student.gateway.channel")
    public String processStudentDetails(Student student);

}
