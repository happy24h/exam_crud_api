package com.example.crudapi.repository;

import com.example.crudapi.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository
    extends JpaRepository<UsersEntity, Integer> {
    List<UsersEntity> findAllByName(String name);
    List<UsersEntity> findAllByNameAndPrice(String name, String price);
    List<UsersEntity> findAllByNameOrPrice(String name, String price);
    List<UsersEntity> findAllByNameContainingIgnoreCase(String name);
    List<UsersEntity> findAllByNameOrderByPrice(String price);

}
