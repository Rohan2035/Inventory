package com.rohan.ecom.controller;

import com.rohan.ecom.dto.LoginDTO;
import com.rohan.ecom.dto.UserRequestDTO;
import com.rohan.ecom.service.LoginService;
import com.rohan.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/refreshToken")
    public Map<String, String> refreshAccessToken(String refreshToken) {
        return Map.of("accessToke", loginService.refreshToken(refreshToken));
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @PostMapping("/signup")
    public Map<String, String> signUp(@RequestBody UserRequestDTO requestDTO) {
        userService.addUser(requestDTO);
        return Map.of("Status", "User successfully added");
    }
}
