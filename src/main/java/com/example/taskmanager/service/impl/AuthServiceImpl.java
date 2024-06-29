package com.example.taskmanager.service.impl;

import com.example.taskmanager.domain.user.User;
import com.example.taskmanager.service.AuthService;
import com.example.taskmanager.service.UserService;
import com.example.taskmanager.web.dto.auth.JwtRequest;
import com.example.taskmanager.web.dto.auth.JwtResponse;
import com.example.taskmanager.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Override
    public JwtResponse login(
            JwtRequest loginRequest
    ) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );
        User user = userService.getByUsername(loginRequest.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(
                user.getId(), user.getPassword(), user.getRoles())
        );
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(
                user.getId(), user.getPassword())
        );
        return jwtResponse;

    }

    @Override
    public JwtResponse refresh(
            String refreshToken
    ) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }

}
