package com.harsh.springsec.services;

import com.harsh.springsec.model.UserPrincipal;
import com.harsh.springsec.model.Users;
import com.harsh.springsec.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserDetailsRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("User not found "+username);
            throw new UsernameNotFoundException("User not found " + username);
        }
        return new UserPrincipal(user);
    }
}
