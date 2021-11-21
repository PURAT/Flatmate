package com.company.flatmate.repository;

import com.company.flatmate.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    List<User> findAll();

    User findByLogin(String login);
}