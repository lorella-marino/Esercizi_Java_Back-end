package it.epicode.s7_l1.prenotazioni;

import it.epicode.s7_l1.dipendenti.Dipendente;
import it.epicode.s7_l1.dipendenti.DipendenteRepository;
import it.epicode.s7_l1.viaggi.Viaggio;
import it.epicode.s7_l1.viaggi.ViaggioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<PrenotazioneResponse> findAll() {
        return prenotazioneRepository.findAll().stream().map(this::toResponse).toList();
    }

    public PrenotazioneResponse toResponse(Prenotazione prenotazione) {
        PrenotazioneResponse prenotazioneResponse = new PrenotazioneResponse();
        BeanUtils.copyProperties(prenotazione, prenotazioneResponse);
        prenotazioneResponse.setDipendenteId(prenotazione.getDipendente().getId());
        prenotazioneResponse.setViaggioId(prenotazione.getViaggio().getId());
        return prenotazioneResponse;
    }

    public PrenotazioneResponse findById(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione non trovata"));
        return toResponse(prenotazione);
    }

    public PrenotazioneResponse create(@Valid PrenotazioneRequest prenotazioneRequest) {
        Prenotazione prenotazione = new Prenotazione();
        BeanUtils.copyProperties(prenotazioneRequest, prenotazione);
        Dipendente dipendente = dipendenteRepository.findById(prenotazioneRequest.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
        Viaggio viaggio = viaggioRepository.findById(prenotazioneRequest.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));

        // Verifica se il dipendente ha già una prenotazione in quella data
        List<Prenotazione> esistenti = prenotazioneRepository
                .findByDipendenteIdAndDataDiRichiesta(dipendente.getId(), prenotazioneRequest.getDataDiRichiesta());

        boolean esisteConflitto = esistenti.stream().anyMatch(p -> !p.getId().equals(prenotazione.getId()));
        if (esisteConflitto) {
            throw new EntityNotFoundException("Il dipendente ha già una prenotazione per questa data.");
        }

        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazioneRepository.save(prenotazione);
        return toResponse(prenotazione);
    }

    public PrenotazioneResponse update(Long id, @Valid PrenotazioneRequest prenotazioneRequest) {
        Prenotazione prenotazione = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione non trovata"));

        Dipendente dipendente = dipendenteRepository.findById(prenotazioneRequest.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
        Viaggio viaggio = viaggioRepository.findById(prenotazioneRequest.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));

        // Verifica se il dipendente ha già una prenotazione in quella data
        List<Prenotazione> esistenti = prenotazioneRepository
                .findByDipendenteIdAndDataDiRichiesta(dipendente.getId(), prenotazioneRequest.getDataDiRichiesta());

        boolean esisteConflitto = esistenti.stream().anyMatch(p -> !p.getId().equals(id));
        if (esisteConflitto) {
            throw new EntityNotFoundException("Il dipendente ha già una prenotazione per questa data.");
        }

        BeanUtils.copyProperties(prenotazioneRequest, prenotazione);
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazioneRepository.save(prenotazione);
        return toResponse(prenotazione);
    }


    public void delete(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
