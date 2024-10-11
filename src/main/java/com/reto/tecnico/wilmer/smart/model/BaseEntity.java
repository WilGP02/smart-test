package com.reto.tecnico.wilmer.smart.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private LocalDateTime created;

  private LocalDateTime modified;

  private LocalDateTime lastLogin;

  @PrePersist
  private void prePersist() {
    created = LocalDateTime.now();
    modified = LocalDateTime.now();
    lastLogin = LocalDateTime.now();
  }

}
