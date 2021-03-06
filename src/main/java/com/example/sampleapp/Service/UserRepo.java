package com.example.sampleapp.Service;

import com.example.sampleapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer>
{
public List<User> findByEmail(String name);
}
