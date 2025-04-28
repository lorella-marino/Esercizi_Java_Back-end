package it.epicode.s7_l1.prenotazioni;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByDipendenteIdAndDataDiRichiesta(Long dipendenteId, String dataDiRichiesta);
}