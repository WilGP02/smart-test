package com.reto.tecnico.wilmer.smart.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reto.tecnico.wilmer.smart.model.Phone;
import com.reto.tecnico.wilmer.smart.validator.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @NotBlank(message = "Nombre requerido")
    private String name;

    @NotBlank(message = "Email requerido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Formato de correo electrónico inválido")
    //@Email(message = "Formato de correo electrónico inválido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @ValidPassword
    private String password;

    private List<Phone> phones;
}
