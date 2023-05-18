package com.bookapp.book.app.rest.api.models;

import com.bookapp.book.app.rest.api.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4 , message = "Username must be min of 4 characters")
    private String firstName;

    private String lastName;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 4 , max=10 , message = "Password must be min of 4 characters and mx od 10 characters")
    private String password;

    private String address;

    private Role role;
}