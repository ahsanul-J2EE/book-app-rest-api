package com.bookapp.book.app.rest.api.services.impl;

import com.bookapp.book.app.rest.api.entity.User;
import com.bookapp.book.app.rest.api.exceptions.ResourceNotFoundException;
import com.bookapp.book.app.rest.api.models.UserDto;
import com.bookapp.book.app.rest.api.repositories.UserRepo;
import com.bookapp.book.app.rest.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.usertoDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {


        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));


        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);

        UserDto userDto1 =  this.usertoDto(updatedUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        return this.usertoDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users =  this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.usertoDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void userDelete(Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        this.userRepo.delete(user);


    }

    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());



        return user;
    }

    private UserDto usertoDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());

        return userDto;
    }
}