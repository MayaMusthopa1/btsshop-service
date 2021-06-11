/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsshop.controller;

import com.btsshop.entity.user.Users;
import com.btsshop.repository.UsersRepository;
import com.btsshop.vo.User;
import com.btsshop.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ITAdmin
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "/saveOrUpdate")
    @ResponseStatus(HttpStatus.OK)
    public Users saveOrUpdate(@RequestBody Users users) {
        try {
            users.setPassword(Util.getMd5(users.getPassword()));
            return usersRepository.save(users);
        } catch (Exception e) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    public Users create(@RequestBody User user) {
        try {
            Users newUser = new Users();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(Util.getMd5(user.getPassword()));
            newUser.setRoleCode(user.getRoleCode());

            return usersRepository.save(newUser);
        } catch (Exception e) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @PostMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(Users users) {
        try {
            usersRepository.delete(users);
            return true;
        } catch (Exception e) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public User loginCosole(@RequestBody Users users) {
        try {
            users.setPassword(Util.getMd5(users.getPassword()));
            Users users1 = usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword());
            if (users1.getRoleCode() < 3) {
                User user = new User();
                user.setPassword(users1.getPassword());
                user.setRoleCode(users1.getRoleCode());
                user.setUserName(users1.getUserName());
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @PostMapping(value = "/authentication")
    @ResponseStatus(HttpStatus.OK)
    public Users authentication(@RequestBody Users users) {
        try {
            users.setPassword(Util.getMd5(users.getPassword()));
            return usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword());
        } catch (Exception e) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}