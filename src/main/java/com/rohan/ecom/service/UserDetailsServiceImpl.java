package com.rohan.ecom.service;


import com.rohan.ecom.dto.UserRequestDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    @Override
    public void addUser(UserRequestDTO userRequestDTO) {

    }
}
