package com.example.sampleapp.Service;

import com.example.sampleapp.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepo extends JpaRepository<UserLogin,Integer>
{
public UserLogin findUserLoginByEmailAndPassword(String email,String password);
}
