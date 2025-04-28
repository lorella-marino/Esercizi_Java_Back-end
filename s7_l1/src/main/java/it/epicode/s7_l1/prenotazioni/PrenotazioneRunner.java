package it.epicode.s7_l1.prenotazioni;

import com.github.javafaker.Faker;
import it.epicode.s7_l1.dipendenti.Dipendente;
import it.epicode.s7_l1.dipendenti.DipendenteRepository;
import it.epicode.s7_l1.viaggi.Viaggio;
import it.epicode.s7_l1.viaggi.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order (3)
public class PrenotazioneRunner implements CommandLineRunner{
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private ViaggioRepository viaggioRepository;
    @Autowired
    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        List<Dipendente> dipendenteList = dipendenteRepository.findAll();
        List<Viaggio> viaggioList = viaggioRepository.findAll();

        for (int i = 0; i < 5; i++) {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDipendente(dipendenteList.get(i));
            prenotazione.setViaggio(viaggioList.get(i));
            prenotazione.setDataDiRichiesta(String.valueOf(faker.date().between(faker.date().past(365, java.util.concurrent.TimeUnit.DAYS), faker.date().future(365, java.util.concurrent.TimeUnit.DAYS))));
            prenotazione.setNote("note: volo, alloggio");
            prenotazioneRepository.save(prenotazione);
        }

    }
}