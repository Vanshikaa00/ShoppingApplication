package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.exception.ResourceNotFoundException;
import com.caseStudy.eCart.models.signUp;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Base64;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class userController {

    @Autowired
    private UserRepository userRepository;

    //Get users
    @GetMapping(path = "/getUser")
    public List<users> getAllUser(){
        return userRepository.findAll();
    }

    //Add users
    @PostMapping("/addUser")
    public users createUser(@Valid @RequestBody users userrs)
    {
        userrs.setRole("user");
        userrs.setActive(1);
        return userRepository.save(userrs);
    }



}
