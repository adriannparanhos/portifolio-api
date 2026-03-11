package br.dev.adriann.portifolio_api.infrastructure.configuration;

import br.dev.adriann.portifolio_api.core.usecase.ListContactMessagesUseCase;
import br.dev.adriann.portifolio_api.core.usecase.SendContactMessageUseCase;
import br.dev.adriann.portifolio_api.core.usecase.port.ContactMessageRepositoryPort;
import br.dev.adriann.portifolio_api.core.usecase.port.EmailNotificationPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SendContactMessageUseCase sendContactMessageUseCase(
            ContactMessageRepositoryPort repositoryPort,
            EmailNotificationPort emailNotificationPort
    ) {
        return new SendContactMessageUseCase(repositoryPort, emailNotificationPort);
    }

    @Bean
    public ListContactMessagesUseCase listContactMessagesUseCase(ContactMessageRepositoryPort repositoryPort) {
        return new ListContactMessagesUseCase(repositoryPort);
    }
}