package br.dev.adriann.portifolio_api.infrastructure.mail.adapter;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;
import br.dev.adriann.portifolio_api.core.usecase.port.EmailNotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GmailNotificationAdapter implements EmailNotificationPort {

    private final JavaMailSender mailSender;

    @Value("${portfolio.mail.recipient}")
    private String recipientEmail;

    @Override
    public void sendNotification(ContactMessage message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject("NOVO CONTACTO: Portefólio - " + message.name());

        String text = String.format(
                "Recebeu uma nova mensagem no seu portefólio!%n%n" +
                        "Nome: %s%n" +
                        "E-mail: %s%n" +
                        "Mensagem:%n%s",
                message.name(), message.email(), message.message()
        );

        mailMessage.setText(text);

        mailSender.send(mailMessage);
    }
}
