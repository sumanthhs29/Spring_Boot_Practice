package com.example.practice.Service;

import com.example.practice.Model.User;
import com.example.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Called everytime when someone tries to authenticate.
        User user = userRepository.findByUserName(userName);
        if(user==null) {
            throw new UsernameNotFoundException("User: "+userName+" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(), new ArrayList<>());
    }

}
