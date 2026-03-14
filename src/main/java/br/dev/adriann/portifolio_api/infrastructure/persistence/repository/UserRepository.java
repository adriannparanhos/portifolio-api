package br.dev.adriann.portifolio_api.infrastructure.persistence.repository;

import br.dev.adriann.portifolio_api.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserDetails findByLogin(String login);
}