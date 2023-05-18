package com.bookapp.book.app.rest.api.services;

import com.bookapp.book.app.rest.api.models.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<Object> createUser(UserDto user);
//    UserDto updateUser(UserDto user, Integer id);
//    UserDto getUserById(Integer id);
//
//    List<UserDto> getAllUser();
//
//    void userDelete (Integer userId);

}
