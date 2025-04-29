package it.epicode.s7_l2.dipendenti;

import it.epicode.s7_l2.cloudinary.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Validated
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public void uploadFotoProfilo(Long id, MultipartFile fotoProfilo) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
        String url = cloudinaryService.uploadImage(fotoProfilo);
        dipendente.setFotoProfilo(url);
        dipendenteRepository.save(dipendente);
    }

    public DipendenteResponse toResponse(Dipendente dipendente) {
        return new DipendenteResponse(
                dipendente.getId(),
                dipendente.getUsername(),
                dipendente.getNome(),
                dipendente.getCognome(),
                dipendente.getEmail(),
                dipendente.getFotoProfilo()
        );
    }

    public List<DipendenteResponse> findAll() {
       List <Dipendente> dipendenti = dipendenteRepository.findAll();
       return dipendenti.stream().map(this::toResponse).toList();
    }

    public DipendenteResponse findById(Long id) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
        return toResponse(dipendente);
    }

    public DipendenteResponse create(@Valid DipendenteRequest dipendenteRequest) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteRequest.getUsername());
        dipendente.setNome(dipendenteRequest.getNome());
        dipendente.setCognome(dipendenteRequest.getCognome());
        dipendente.setEmail(dipendenteRequest.getEmail());
        dipendenteRepository.save(dipendente);
        return toResponse(dipendente);
    }

    public DipendenteResponse update(Long id, DipendenteRequest dipendenteRequest) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));
        dipendente.setUsername(dipendenteRequest.getUsername());
        dipendente.setNome(dipendenteRequest.getNome());
        dipendente.setCognome(dipendenteRequest.getCognome());
        dipendente.setEmail(dipendenteRequest.getEmail());
        dipendenteRepository.save(dipendente);
        return toResponse(dipendente);
    }

    public void delete(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
