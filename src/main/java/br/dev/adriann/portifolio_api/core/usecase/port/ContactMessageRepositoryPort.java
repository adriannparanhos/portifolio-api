package br.dev.adriann.portifolio_api.core.usecase.port;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;

import java.util.List;

public interface ContactMessageRepositoryPort {
    ContactMessage save(ContactMessage contactMessage);
    List<ContactMessage> findAll();
}