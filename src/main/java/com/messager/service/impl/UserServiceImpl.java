package com.messager.service.impl;

import com.messager.model.domain.User;
import com.messager.repository.UserRepo;
import com.messager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUser(Long idUser) {
        return userRepo.findById(idUser);
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public String deleteUser(Long idUser) {
        userRepo.deleteById(idUser);
        return "Пользователь c userId: " + idUser + " удален.";
    }
}
