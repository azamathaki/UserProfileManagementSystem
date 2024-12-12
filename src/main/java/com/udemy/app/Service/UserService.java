package com.udemy.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.app.model.Profile;
import com.udemy.app.model.User;
import com.udemy.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserProfile(User inputUser, Profile inputProfile){
        inputUser.setProfile(inputProfile);
        inputProfile.setUser(inputUser);

        userRepository.save(inputUser);
        return inputUser;
    }

    public User getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with given ID: " + id));
        return user;
    }

    public User updateProfile(Long id, Profile profile){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with given ID: " + id));
        user.setProfile(profile);
        profile.setUser(user);

        userRepository.save(user);
        return user;

    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
