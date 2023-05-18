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
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){

        UserDto updatedUser =  this.userService.updateUser(userDto,userId);

        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

//        UserDto updatedUser =  this.userService.updateUser(userDto,userId);

        this.userService.userDelete(userId);

        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUser());
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUserById( @PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }





}