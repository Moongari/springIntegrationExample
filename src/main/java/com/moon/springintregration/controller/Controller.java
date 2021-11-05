package com.moon.springintregration.controller;


import com.moon.springintregration.model.Address;
import com.moon.springintregration.model.Student;
import com.moon.springintregration.service.IntegrationGateway;
import com.moon.springintregration.service.IntegrationGatewayGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/home")
public class Controller {


    @Autowired
    private IntegrationGateway integrationGateway;

    @Autowired
    private IntegrationGatewayGeneric integrationGatewayGeneric;


    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
        return integrationGateway.sendMessage(name);
    }

    @PostMapping("/Student")
    public String processStudentDetails(@RequestBody Student student){
        return integrationGateway.processStudentDetails(student);
    }

    @PostMapping("/Address")
    public void processAddressDetails(@RequestBody Address address){
         integrationGatewayGeneric.process(address);
    }


}
