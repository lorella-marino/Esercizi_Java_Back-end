package it.epicode.s7_l2.security.auth.authorization;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
