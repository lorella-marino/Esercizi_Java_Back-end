package it.epicode.s7_l2.viaggi;


import it.epicode.s7_l2.viaggi.stato.Stato;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public ViaggioResponse create(@Valid ViaggioRequest viaggioRequest) {
        Viaggio viaggio = new Viaggio();
        BeanUtils.copyProperties(viaggioRequest, viaggio);
        viaggio.setDestinazione(viaggioRequest.getDestinazione());
        viaggio.setData(viaggioRequest.getData());
        viaggioRepository.save(viaggio);
        return toResponse(viaggio);
    }

    public ViaggioResponse toResponse(Viaggio viaggio) {
        ViaggioResponse  viaggioResponse = new ViaggioResponse();
        BeanUtils.copyProperties(viaggio, viaggioResponse);
        return viaggioResponse;
    }

    public List<ViaggioResponse> findAll() {
        List<Viaggio> viaggi = viaggioRepository.findAll();
        return viaggi.stream().map(this::toResponse).toList();
    }

    public ViaggioResponse findById(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        return toResponse(viaggio);
    }

    public ViaggioResponse update(Long id, ViaggioRequest viaggioRequest) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        BeanUtils.copyProperties(viaggioRequest, viaggio);
        viaggioRepository.save(viaggio);
        return toResponse(viaggio);
    }

    // per modificare solo lo Stato
    public void updateStato(Long id, Stato stato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        viaggio.setStato(stato);
        viaggioRepository.save(viaggio);
    }

    public void delete(Long id) {
        viaggioRepository.deleteById(id);
    }
}
