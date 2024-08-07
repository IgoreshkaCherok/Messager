package com.messager.controller;

import com.messager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.messager.model.domain.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.getUser(idUser));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable Long idUser, @RequestBody User user) {
        user.setIdUser(idUser);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{idUser}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleteUser(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.deleteUser(idUser));
    }
}
