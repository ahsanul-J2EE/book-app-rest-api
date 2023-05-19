package com.bookapp.book.app.rest.api.services.impl;

import com.bookapp.book.app.rest.api.exceptions.InvalidUserException;
import com.bookapp.book.app.rest.api.repositories.UserRepo;
import com.bookapp.book.app.rest.api.units.JwtService;
import com.bookapp.book.app.rest.api.models.AuthenticationRequest;
import com.bookapp.book.app.rest.api.models.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;

    public ResponseEntity<Object> login(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );

            var user = userRepo.findByEmail(authenticationRequest.getEmail());
            var jwtToken = jwtService.generateToken(user);
            AuthenticationResponse authRes = AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
            return new ResponseEntity<>(authRes, HttpStatus.OK);

        } catch (BadCredentialsException ex) {
            // Handle invalid user exception
            throw new InvalidUserException("Invalid email or password");


        }
    }
}
