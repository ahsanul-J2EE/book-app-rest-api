package com.bookapp.book.app.rest.api.controllers;

import com.bookapp.book.app.rest.api.models.ApiResponse;
import com.bookapp.book.app.rest.api.models.UserDto;
import com.bookapp.book.app.rest.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto){
//        return userService.createUser(userDto);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }


}