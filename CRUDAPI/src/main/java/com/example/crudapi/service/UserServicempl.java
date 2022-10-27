package com.example.crudapi.service;

import com.example.crudapi.entity.UsersEntity;
import com.example.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicempl implements Userservice {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(UsersEntity u) {
        userRepository.save(u);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);


    }

    @Override
    public UsersEntity findById(Integer id) {
//        return null;
        Optional<UsersEntity> userE = userRepository.findById(id);
        if(userE.isPresent()) {
            return userE.get();
        }

        return null;
    }

    @Override
    public List<UsersEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UsersEntity> findAllByName(String name) {
        return null;
    }
}
