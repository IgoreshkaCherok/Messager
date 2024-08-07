package com.messager.service;

import com.messager.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long idUser);

    User createUser(User user);

    List<User> getUsers();

    User updateUser(User user);

    String deleteUser(Long idUser);
}

