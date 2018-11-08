package com.tuncerbasaran.workshop.controller;

import com.amazonaws.util.EC2MetadataUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/")
    public String home() {
        String ipAddress = EC2MetadataUtils.getPrivateIpAddress();
        String instanceId = EC2MetadataUtils.getInstanceId();
        return ipAddress + " - " + instanceId + " - " + activeProfile;
    }
}
