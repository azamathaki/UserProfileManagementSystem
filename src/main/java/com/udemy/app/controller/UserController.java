package com.udemy.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.app.Service.UserService;
import com.udemy.app.model.Profile;
import com.udemy.app.model.User;
import com.udemy.app.model.UserProfile;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService service;


    @PostMapping("/users")
    public User createUserAndProfile(@RequestBody UserProfile userProfile){
        return service.createUserProfile(userProfile.getUser(), userProfile.getProfile());
    }


    // get an user by id  /api/users/{id}
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id")Long id){
        return service.getUser(id);
    }
 
    // update a users's profile
    @PutMapping("/users/{id}")
    public User updateProfile(@PathVariable("id") Long id,@RequestBody Profile profile){
        return service.updateProfile(id,profile);
    }

    // delete a user with profile
    @DeleteMapping("/users/{id}")
    public String deleteUserWithProfile(@PathVariable("id") Long id){
        service.deleteUser(id);
        return "deleted user ID: " + id;
    }
}
