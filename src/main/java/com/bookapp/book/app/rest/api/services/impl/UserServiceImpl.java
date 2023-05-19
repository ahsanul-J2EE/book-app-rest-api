package com.bookapp.book.app.rest.api.services.impl;

import com.bookapp.book.app.rest.api.entity.User;
import com.bookapp.book.app.rest.api.exceptions.ResourceNotFoundException;
import com.bookapp.book.app.rest.api.models.AuthenticationResponse;
import com.bookapp.book.app.rest.api.models.UserDto;
import com.bookapp.book.app.rest.api.repositories.UserRepo;
import com.bookapp.book.app.rest.api.services.UserService;
import com.bookapp.book.app.rest.api.units.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bookapp.book.app.rest.api.exceptions.BookDoseNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<Object> createUser(UserDto userDto) {

//        User user = this.dtoToUser(userDto);
//        User savedUser = this.userRepo.save(user);
//        return this.usertoDto(savedUser);
        Optional<User> checkUser = Optional.ofNullable(userRepo.findByEmail(userDto.getEmail()));

        if(checkUser.isPresent()){
            throw new BookDoseNotFoundException("User already exists");
        }

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole())
                .build();
        userRepo.save(user);
        AuthenticationResponse authRes = AuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
        return new ResponseEntity<>(authRes, HttpStatus.CREATED);

    }



}