package com.moon.springintregration.controller;


import com.moon.springintregration.model.Student;
import com.moon.springintregration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/home")
public class Controller {


    @Autowired
    private IntegrationGateway integrationGateway;


    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
        return integrationGateway.sendMessage(name);
    }

    @PostMapping
    public String processStudentDetails(@RequestBody Student student){
        return integrationGateway.processStudentDetails(student);
    }


}
