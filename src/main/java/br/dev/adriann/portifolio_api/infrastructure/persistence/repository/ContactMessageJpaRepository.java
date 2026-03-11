package br.dev.adriann.portifolio_api.infrastructure.persistence.repository;

import br.dev.adriann.portifolio_api.infrastructure.persistence.entity.ContactMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactMessageJpaRepository extends JpaRepository<ContactMessageEntity, UUID> {
}
