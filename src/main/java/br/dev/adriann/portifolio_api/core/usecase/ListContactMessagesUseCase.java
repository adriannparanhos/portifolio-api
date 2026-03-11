package br.dev.adriann.portifolio_api.core.usecase;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;
import br.dev.adriann.portifolio_api.core.usecase.port.ContactMessageRepositoryPort;

import java.util.List;

public class ListContactMessagesUseCase {

    private final ContactMessageRepositoryPort repositoryPort;

    public ListContactMessagesUseCase(ContactMessageRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public List<ContactMessage> execute() {
        return repositoryPort.findAll();
    }
}