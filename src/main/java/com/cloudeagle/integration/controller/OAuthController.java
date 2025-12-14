package com.cloudeagle.integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/oauth/callback")
    public String handleCallback(@RequestParam("code") String code) {
        return """
               OAuth authorization successful!

               Authorization code:
               """ + code + """

               """;
    }
}
