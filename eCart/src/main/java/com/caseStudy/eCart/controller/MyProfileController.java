package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repo.CartRepository;
import com.caseStudy.eCart.repo.UserRepository;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {

    @Autowired
     UserRepository userRepository;
    @Autowired
    CurrentUserService currentUserService;


    @RequestMapping(value = "/getUserData", method = RequestMethod.GET)
    @ResponseBody
//    @GetMapping(value = "/getUserData")
    public users getUserData(Principal principal) {
        return currentUserService.getUserProfile(principal);
    }

    @RequestMapping(value = "/updateUserData", method = RequestMethod.PUT)
    @ResponseBody
//    @PutMapping(value = "/updateUserData")
//    @ResponseBody
    public users updateUserData(@Valid @RequestBody users users) {
        users.setActive(1);
       // users.setRole("user");
        userRepository.save(users);
        return users;
    }

}
