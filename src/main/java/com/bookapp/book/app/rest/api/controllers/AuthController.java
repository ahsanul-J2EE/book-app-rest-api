package com.bookapp.book.app.rest.api.controllers;

import lombok.RequiredArgsConstructor;
import com.bookapp.book.app.rest.api.models.AuthenticationResponse;
import com.bookapp.book.app.rest.api.models.AuthenticationRequest;
import com.bookapp.book.app.rest.api.services.impl.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/login")
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<>(authenticationService.login(authenticationRequest), HttpStatus.OK);
    }
}
