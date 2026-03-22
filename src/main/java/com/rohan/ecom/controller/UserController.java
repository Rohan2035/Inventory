package com.rohan.ecom.controller;

import com.rohan.ecom.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public Map<String, String> login(LoginDTO loginDTO) {
        return Map.of();
    }
}
