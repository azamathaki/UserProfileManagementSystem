package com.udemy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    // code here
    //
}
