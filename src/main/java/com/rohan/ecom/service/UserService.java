package com.rohan.ecom.service;

import com.rohan.ecom.dto.UserRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void addUser(UserRequestDTO userRequestDTO);
}
