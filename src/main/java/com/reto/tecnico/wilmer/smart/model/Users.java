package com.reto.tecnico.wilmer.smart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users extends BaseEntity {

  private String name;

  private String email;

  private String password;

  private String token;

  private Boolean isActive = Boolean.TRUE;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Phone> phones;
}
