package it.epicode.s7_l1.prenotazioni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneResponse {
    private Long id;
    private Long viaggioId;
    private Long dipendenteId;
    private String dataDiRichiesta;
    private String note;
}
