package com.springbootstudy.Estudando_Java_SpringBoot.services;

import com.springbootstudy.Estudando_Java_SpringBoot.dto.UserRequestDTO;
import com.springbootstudy.Estudando_Java_SpringBoot.dto.UserResponseDTO;
import com.springbootstudy.Estudando_Java_SpringBoot.entities.User;
import com.springbootstudy.Estudando_Java_SpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return new UserResponseDTO(user.get().getId(), user.get().getName());
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public UserResponseDTO criarUsuario(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setPassword(userRequestDTO.getPassword());

        User saved = userRepository.save(user);

        return new UserResponseDTO(saved.getId(), saved.getName());

    }
}
