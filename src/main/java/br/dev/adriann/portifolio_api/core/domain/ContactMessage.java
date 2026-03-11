package br.dev.adriann.portifolio_api.core.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ContactMessage(
        UUID id,
        String name,
        String email,
        String message,
        OffsetDateTime createdAt
) {
    public ContactMessage {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        if (message == null || message.trim().length() < 10) {
            throw new IllegalArgumentException("A mensagem deve ter pelo menos 10 caracteres.");
        }
    }

    public static ContactMessage createNew(String name, String email, String message) {
        return new ContactMessage(
                UUID.randomUUID(),
                name,
                email,
                message,
                OffsetDateTime.now()
        );
    }
}