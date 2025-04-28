package it.epicode.s7_l1.viaggi;

import it.epicode.s7_l1.viaggi.stato.Stato;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<ViaggioResponse> findAll() {
        return viaggioService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ViaggioResponse findById(@PathVariable Long id) {
        return viaggioService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ViaggioResponse create(@RequestBody @Valid ViaggioRequest viaggioRequest) {
        return viaggioService.create(viaggioRequest);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ViaggioResponse update(@PathVariable Long id, @RequestBody @Valid ViaggioRequest viaggioRequest) {
        return viaggioService.update(id, viaggioRequest);
    }

    // per mostrare gli Stati e scriverli correttamente
    @GetMapping("/visualizzaStatiPerLaModifica")
    @PreAuthorize("hasRole('ADMIN')")
    public Stato[] getStati() {
        return Stato.values();
    }

    // per modificare solo lo Stato
    @PutMapping("/{id}/stato")
    @PreAuthorize("hasRole('ADMIN')")
    public ViaggioResponse updateStato(@PathVariable Long id, @RequestBody Stato stato) {
        viaggioService.updateStato(id, stato);
        return viaggioService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        viaggioService.delete(id);
    }
}
