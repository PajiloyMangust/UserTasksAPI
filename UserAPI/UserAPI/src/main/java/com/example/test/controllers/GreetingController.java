package com.example.test.controllers;

import com.example.test.Entity.UserEntity;
import com.example.test.exceptions.UserAlreadyExistException;
import com.example.test.exceptions.UserNotFoundException;
import com.example.test.repository.UserRepo;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class GreetingController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранён!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping("")
    public ResponseEntity getOneUserr(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}