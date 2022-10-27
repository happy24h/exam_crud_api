package com.example.crudapi.service;

import com.example.crudapi.entity.UsersEntity;

import java.util.List;


public interface Userservice {
    public void saveUser(UsersEntity u);
    public void deleteUser(Integer id);
    public UsersEntity findById(Integer id);
    public List<UsersEntity> findAll();
    public List<UsersEntity> findAllByName(String name);
}
