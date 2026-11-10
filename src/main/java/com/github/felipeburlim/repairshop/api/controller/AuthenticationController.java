package com.github.felipeburlim.repairshop.api.controller;

import com.github.felipeburlim.repairshop.api.dto.AuthenticationData;
import com.github.felipeburlim.repairshop.api.dto.TokenJWTData;
import com.github.felipeburlim.repairshop.api.model.AppUser;
import com.github.felipeburlim.repairshop.api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWTData> login(@RequestBody @Valid AuthenticationData data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((AppUser) Objects.requireNonNull(authentication.getPrincipal()));
        return ResponseEntity.ok(new TokenJWTData(tokenJWT));
    }
}
