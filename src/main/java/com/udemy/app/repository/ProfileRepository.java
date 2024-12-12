package com.udemy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.app.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
