package it.epicode.s7_l1.viaggi;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioRequest {
    @NotBlank  (message = "Destinazione obbligatoria")
    private String destinazione;
    @NotBlank (message = "Data obbligatoria")
    private String data;
}
