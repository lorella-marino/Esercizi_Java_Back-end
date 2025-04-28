package it.epicode.s7_l1.prenotazioni;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<PrenotazioneResponse> findAll() {
        return prenotazioneService.findAll();
    }

    @GetMapping ("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PrenotazioneResponse findById(@PathVariable Long id) {
        return prenotazioneService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public PrenotazioneResponse create(@RequestBody @Valid PrenotazioneRequest prenotazioneRequest) {
        return prenotazioneService.create(prenotazioneRequest);
    }

    @PutMapping ("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PrenotazioneResponse update(@PathVariable Long id, @RequestBody PrenotazioneRequest prenotazioneRequest) {
        return prenotazioneService.update(id, prenotazioneRequest);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        prenotazioneService.delete(id);
    }
}
