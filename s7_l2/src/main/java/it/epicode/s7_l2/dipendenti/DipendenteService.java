package it.epicode.s7_l2.dipendenti;

import it.epicode.s7_l2.cloudinary.CloudinaryService;
import it.epicode.s7_l2.security.auth.app_user.AppUser;
import it.epicode.s7_l2.security.auth.app_user.Role;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Service
@Validated
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        dipendente.setNome(dipendenteRequest.getNome());
        dipendente.setCognome(dipendenteRequest.getCognome());
        dipendente.setEmail(dipendenteRequest.getEmail());
        dipendenteRepository.save(dipendente);
        return toResponse(dipendente);
    }

    // Bcrypto -> protezione della password durante l'update dell'utente
    public Dipendente update(Long id,  DipendenteRequest request, AppUser utenteLoggato) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con id: " + id));

        boolean isAdmin = utenteLoggato.getRoles().contains(Role.ROLE_ADMIN);

        if(dipendente.getAppUser().getId() == utenteLoggato.getId() || isAdmin) {
            BeanUtils.copyProperties(request, dipendente);
        } else {
            throw new IllegalArgumentException("Non sei autorizzato a modificare questo dipendente");
        }

        return dipendenteRepository.save(dipendente);


    }

    public void delete(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
