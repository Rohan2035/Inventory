package com.rohan.ecom.controller;

import com.rohan.ecom.dto.LoginDTO;
import com.rohan.ecom.dto.UserRequestDTO;
import com.rohan.ecom.service.JwtUtil;
import com.rohan.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {

        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password())
        );

        if(authentication.isAuthenticated()) {
            return Map.of("Token", jwtUtil.generateToken(loginDTO.username()));
        }

        return Map.of("Status", "Username not found");
    }

    @PostMapping("/signup")
    public Map<String, String> signUp(@RequestBody UserRequestDTO requestDTO) {
        userService.addUser(requestDTO);
        return Map.of("Status", "User successfully added");
    }
}
