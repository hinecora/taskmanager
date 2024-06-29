package com.example.taskmanager.service;


import com.example.taskmanager.web.dto.auth.JwtRequest;
import com.example.taskmanager.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
