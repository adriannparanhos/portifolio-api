package br.dev.adriann.portifolio_api.core.usecase.port;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;

public interface EmailNotificationPort {
    void sendNotification(ContactMessage message);
}