package br.dev.adriann.portifolio_api.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank(message = "O login não pode ser vazio.")
        String login,

        @NotBlank(message = "A senha não pode ser vazia.")
        String password
) {}