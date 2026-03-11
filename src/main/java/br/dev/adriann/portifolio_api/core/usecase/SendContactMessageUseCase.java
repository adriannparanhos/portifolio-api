package br.dev.adriann.portifolio_api.core.usecase;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;
import br.dev.adriann.portifolio_api.core.usecase.port.ContactMessageRepositoryPort;
import br.dev.adriann.portifolio_api.core.usecase.port.EmailNotificationPort;

public class SendContactMessageUseCase {

    private final ContactMessageRepositoryPort repositoryPort;
    private final EmailNotificationPort emailNotificationPort;

    public SendContactMessageUseCase(ContactMessageRepositoryPort repositoryPort, EmailNotificationPort emailNotificationPort) {
        this.repositoryPort = repositoryPort;
        this.emailNotificationPort = emailNotificationPort;
    }

    public ContactMessage execute(String name, String email, String message) {
        ContactMessage newContactMessage = ContactMessage.createNew(name, email, message);

        ContactMessage savedMessage = repositoryPort.save(newContactMessage);

        emailNotificationPort.sendNotification(savedMessage);

        return savedMessage;
    }
}
