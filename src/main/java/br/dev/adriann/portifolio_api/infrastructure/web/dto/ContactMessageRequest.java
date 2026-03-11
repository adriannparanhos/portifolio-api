package br.dev.adriann.portifolio_api.infrastructure.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactMessageRequest(
        @NotBlank(message = "O nome é obrigatório.")
        String name,

        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Formato de e-mail inválido.")
        String email,

        @NotBlank(message = "A mensagem é obrigatória.")
        @Size(min = 10, message = "A mensagem deve ter pelo menos 10 caracteres.")
        String message
) {}
