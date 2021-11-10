package com.company.flatmate.service;

import com.company.flatmate.entity.User;
import com.company.flatmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        repository.save(user);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }


}
