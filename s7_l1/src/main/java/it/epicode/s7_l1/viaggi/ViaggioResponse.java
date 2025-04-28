package it.epicode.s7_l1.viaggi;


import it.epicode.s7_l1.viaggi.stato.Stato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioResponse {
    private Long id;
    private String destinazione;
    private String data;
    private Stato stato ;

}
