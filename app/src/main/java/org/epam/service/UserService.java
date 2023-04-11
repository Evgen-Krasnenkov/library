package org.epam.service;

import org.epam.dao.UserRepository;
import org.epam.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }
}
