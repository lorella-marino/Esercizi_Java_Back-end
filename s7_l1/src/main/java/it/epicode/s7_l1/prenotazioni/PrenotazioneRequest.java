package it.epicode.s7_l1.prenotazioni;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneRequest {
    @Min(value = 1, message = "Viaggio obbligatorio")
    private Long viaggioId;
    @Min(value = 1, message = "Dipendente obbligatorio")
    private Long dipendenteId;
    private String dataDiRichiesta;
    private String note;
}
