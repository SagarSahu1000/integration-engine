package com.cloudeagle.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudeagle.integration.entity.TempUser;
import com.cloudeagle.integration.service.IntegrationService;

@RestController
@RequestMapping("/integrations")
public class IntegrationController {

    @Autowired
    IntegrationService service;

    @PostMapping("/calendly/users")
    public List<TempUser> sync(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        return service.fetchUsers(1L, token);
    }
}
