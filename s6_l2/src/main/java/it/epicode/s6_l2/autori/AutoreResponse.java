package it.epicode.s6_l2.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreResponse {
    private Long id;
    private String nome;
}
