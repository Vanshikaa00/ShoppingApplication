package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class CurrentUserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<users> CurrentUser(Principal principal) {
        String username=principal.getName();
        return userRepository.findByUsername(username);
    }

    public Long getUserIdd (Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get().getUserId();
    }

    public users getUserProfile(Principal principal) {
        Optional <users> myp = userRepository.findByUsername(principal.getName());
        return myp.get();
    }

}
