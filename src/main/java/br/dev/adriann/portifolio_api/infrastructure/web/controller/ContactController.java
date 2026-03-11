package br.dev.adriann.portifolio_api.infrastructure.web.controller;

import br.dev.adriann.portifolio_api.core.usecase.ListContactMessagesUseCase;
import br.dev.adriann.portifolio_api.core.usecase.SendContactMessageUseCase;
import br.dev.adriann.portifolio_api.infrastructure.web.dto.ContactMessageRequest;
import br.dev.adriann.portifolio_api.infrastructure.web.dto.ContactMessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final SendContactMessageUseCase sendContactMessageUseCase;
    private final ListContactMessagesUseCase listContactMessagesUseCase;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@Valid @RequestBody ContactMessageRequest request) {
        sendContactMessageUseCase.execute(request.name(), request.email(), request.message());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ContactMessageResponse>> listMessages() {
        List<ContactMessageResponse> response = listContactMessagesUseCase.execute().stream()
                .map(msg -> new ContactMessageResponse(
                        msg.id(), msg.name(), msg.email(), msg.message(), msg.createdAt()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}
