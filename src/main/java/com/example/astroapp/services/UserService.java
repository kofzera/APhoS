package com.example.astroapp.services;

import com.example.astroapp.dao.UserRepo;
import com.example.astroapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void processOAuthPostLogin(String sub) {
        if (!userRepo.existsById(sub)) {
            User newUser = new User(sub);
            userRepo.save(newUser);
        }
    }

    public User getCurrentUser() {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        String userId = principal.getAttribute("sub");
        return userRepo.findByUserID(userId);
    }
}
