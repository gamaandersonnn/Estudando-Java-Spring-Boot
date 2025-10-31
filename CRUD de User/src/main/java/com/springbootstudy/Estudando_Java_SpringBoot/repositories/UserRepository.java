package com.springbootstudy.Estudando_Java_SpringBoot.repositories;

import com.springbootstudy.Estudando_Java_SpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
