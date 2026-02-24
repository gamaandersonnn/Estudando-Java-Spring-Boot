package com.example.Spring_JWT_CRUD.services;

import com.example.Spring_JWT_CRUD.entities.User;
import com.example.Spring_JWT_CRUD.entities.dtos.LoginUserDTO;
import com.example.Spring_JWT_CRUD.entities.dtos.RegisterUserDTO;
import com.example.Spring_JWT_CRUD.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService (
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    )
    {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User signup(RegisterUserDTO input){
        User user = new User();

         user.setFullName(input.getFullName());
         user.setEmail(input.getEmail());
         user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
