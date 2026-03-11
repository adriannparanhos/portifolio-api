package br.dev.adriann.portifolio_api.infrastructure.web.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ContactMessageResponse(
        UUID id,
        String name,
        String email,
        String message,
        OffsetDateTime createdAt
) {}
