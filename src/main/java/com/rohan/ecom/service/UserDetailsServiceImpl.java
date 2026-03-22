package com.rohan.ecom.service;


import com.rohan.ecom.dto.UserRequestDTO;
import com.rohan.ecom.entity.User;
import com.rohan.ecom.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDetailsRepository.findUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Override
    public void addUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(user.getUsername());
    }
}
