package com.moon.springintregration.service;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
public interface IntegrationGatewayGeneric {
    @Gateway(requestChannel = "router.channel")
    <T> void process(T object);

}
