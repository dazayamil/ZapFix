package com.teamzapfix.zapfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teamzapfix.zapfix.model.entity.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByPhone(String phone);
    List<Client> findAllByIsActiveTrue();
}
