/*
package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.Optional;

public class userService {
    @Autowired
    private UserRepository userRepository;

    public Optional<users> CurrentUser(Principal principal) {
        String username=principal.getName();
        return userRepository.findByUsername(username);
    }

    public Long getUserId (Principal principal) {
        String username = principal.getName();
        Long id = userRepository.findByUsername(username).get().getId();
        return id;
    }



    public Optional<users> getUserProfile(Principal principal) {
        return userRepository.findByUsername(principal.getName());
    }


 public ResponseEntity<?> checkDetails(users user,Principal principal) {
        Optional <users> usercheck = userRepository.findByUsername(principal.getName());
         Optional <users> usercheckinfo = userRepository.findByUsername(user.getUsername());
         if(usercheckinfo.isPresent()& usercheckinfo.get().getUsername()!=usercheck.get().getUsername());
         HttpHeaders responseHeader = new HttpHeaders();
         return user;
     }

}
*/
