package com.example.crudapi.controller;

import com.example.crudapi.entity.UsersEntity;
import com.example.crudapi.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class UserController {
    @Autowired
    Userservice userService;

    @RequestMapping(value = "list-product", method = RequestMethod.GET)
    public ResponseEntity<List<UsersEntity>> findAllUser() {
        List<UsersEntity> lsUser = userService.findAll();
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UsersEntity>>(lsUser, HttpStatus.OK);
    }

    //user/1
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersEntity> findUserById(@PathVariable("id") Integer id) {
        UsersEntity u = userService.findById(id);
        return new ResponseEntity<UsersEntity>(u, HttpStatus.OK);
    }

    //userbyname?name=oanh
    @RequestMapping(value = "userbyname", method = RequestMethod.GET)
    public ResponseEntity<List<UsersEntity>> findAllUser(@PathParam("name") String name) {
        List<UsersEntity> lsUser = userService.findAllByName(name);
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UsersEntity>>(lsUser, HttpStatus.OK);
    }

    @RequestMapping(value = "create-product", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> saveNewUser(@RequestBody UsersEntity u) {
        userService.saveUser(u);
        return new ResponseEntity<UsersEntity>(u, HttpStatus.OK);
    }

    //http://localhost:8080/updateUser?id=1
    @RequestMapping(value = "update-product", method = RequestMethod.PUT)
    public ResponseEntity<UsersEntity> updateUser(
//            @PathParam("id") Integer id,
            @RequestBody UsersEntity u) {
//        UsersEntity oldUser = userService.findById(id)
//                ;
//        oldUser.setEmail(u.getEmail());
//        oldUser.setName(u.getName());
//        oldUser.setPhone(u.getPhone());
        userService.saveUser(u);
        return new ResponseEntity<UsersEntity>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "delete-product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsersEntity> deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id)
        ;
        return ResponseEntity.ok().build();
    }
}
