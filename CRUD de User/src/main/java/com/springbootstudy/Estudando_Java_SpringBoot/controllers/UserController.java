package com.springbootstudy.Estudando_Java_SpringBoot.controllers;

import com.springbootstudy.Estudando_Java_SpringBoot.dto.UserRequestDTO;
import com.springbootstudy.Estudando_Java_SpringBoot.dto.UserResponseDTO;
import com.springbootstudy.Estudando_Java_SpringBoot.entities.User;
import com.springbootstudy.Estudando_Java_SpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public UserResponseDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public UserResponseDTO criarUsuario(@RequestBody UserRequestDTO user){
        return userService.criarUsuario(user);
    }
}
