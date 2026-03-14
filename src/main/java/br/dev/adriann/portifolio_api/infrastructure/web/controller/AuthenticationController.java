package br.dev.adriann.portifolio_api.infrastructure.web.controller;

import br.dev.adriann.portifolio_api.infrastructure.persistence.entity.UserEntity;
import br.dev.adriann.portifolio_api.infrastructure.security.TokenService;
import br.dev.adriann.portifolio_api.infrastructure.web.dto.AuthenticationRequest;
import br.dev.adriann.portifolio_api.infrastructure.web.dto.AuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(request.login(), request.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken(((UserEntity) auth.getPrincipal()).getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}