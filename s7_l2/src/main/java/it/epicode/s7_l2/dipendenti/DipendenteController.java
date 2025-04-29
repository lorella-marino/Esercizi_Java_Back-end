package it.epicode.s7_l2.dipendenti;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @PatchMapping(path = "/{id}/fotoprofilo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('USER')")
    public void uploadFotoProfilo(@RequestParam Long id, @RequestParam MultipartFile file) {
        dipendenteService.uploadFotoProfilo(id, file);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<DipendenteResponse> findAll() {
        return dipendenteService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public DipendenteResponse findById(@PathVariable Long id) {
        return dipendenteService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public DipendenteResponse create(@RequestBody @Valid DipendenteRequest dipendenteRequest) {
        return dipendenteService.create(dipendenteRequest);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public DipendenteResponse update(@PathVariable Long id, @RequestBody DipendenteRequest dipendenteRequest) {
        return dipendenteService.update(id, dipendenteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void delete(@PathVariable Long id) {
        dipendenteService.delete(id);
    }

}
