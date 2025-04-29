package it.epicode.s7_l2.security.auth.authorization;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;
}
