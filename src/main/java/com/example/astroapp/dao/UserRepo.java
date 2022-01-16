package com.example.astroapp.dao;

import com.example.astroapp.entities.SpaceObject;
import com.example.astroapp.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, String> {

    @Override
    public List<User> findAll();

    @Query(nativeQuery = true, value =
            "SELECT * FROM users where google_sub = ?1")
    User findByUserID(String userID);
}
