package br.dev.adriann.portifolio_api.infrastructure.persistence.adapter;

import br.dev.adriann.portifolio_api.core.domain.ContactMessage;
import br.dev.adriann.portifolio_api.core.usecase.port.ContactMessageRepositoryPort;
import br.dev.adriann.portifolio_api.infrastructure.persistence.entity.ContactMessageEntity;
import br.dev.adriann.portifolio_api.infrastructure.persistence.repository.ContactMessageJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactMessageRepositoryAdapter implements ContactMessageRepositoryPort {

    private final ContactMessageJpaRepository jpaRepository;

    @Override
    public ContactMessage save(ContactMessage domainMessage) {
        ContactMessageEntity entity = ContactMessageEntity.builder()
                .id(domainMessage.id())
                .name(domainMessage.name())
                .email(domainMessage.email())
                .message(domainMessage.message())
                .createdAt(domainMessage.createdAt())
                .build();

        ContactMessageEntity savedEntity = jpaRepository.save(entity);

        return new ContactMessage(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getEmail(),
                savedEntity.getMessage(),
                savedEntity.getCreatedAt()
        );
    }

    @Override
    public List<ContactMessage> findAll() {
        return jpaRepository.findAll().stream()
                .map(entity -> new ContactMessage(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getMessage(),
                        entity.getCreatedAt()
                ))
                .toList();
    }
}