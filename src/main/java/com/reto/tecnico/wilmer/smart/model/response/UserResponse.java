package com.reto.tecnico.wilmer.smart.model.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserResponse {


    private UUID id;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    private boolean isActive;

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
