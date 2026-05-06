package com.example.restAPIdemo.api.controller;
import com.example.restAPIdemo.api.model.User;
import com.example.restAPIdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
 private UserService userService;
 @Autowired
 public UserController(UserService userService){
 this.userService=userService;
 }
 @GetMapping("/user/{id}")
 public User getUser(@PathVariable Integer id) {
 User user=userService.getUser(id);
 return user;
 }
}