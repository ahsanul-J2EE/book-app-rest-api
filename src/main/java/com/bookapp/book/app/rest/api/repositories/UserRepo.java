package com.bookapp.book.app.rest.api.repositories;


import com.bookapp.book.app.rest.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);


}