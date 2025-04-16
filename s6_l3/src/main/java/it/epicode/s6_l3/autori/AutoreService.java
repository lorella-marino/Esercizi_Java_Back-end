package it.epicode.s6_l3.autori;

import it.epicode.s6_l3.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public Page<AutoreResponse> findAll(Pageable pageable){
        return autoreRepository.findAll(pageable)
                .map(autore -> new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome())); }

    public AutoreResponse findById(Long id) {
        Autore autore = autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    public CommonResponse create(@Valid AutoreRequest autoreRequest) {
        Autore autore = new Autore();
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setDataDiNascita(autoreRequest.getDataDiNascita());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);
        return new CommonResponse (autore.getId());
    }

    public AutoreResponse update(Long id, AutoreRequest autoreRequest) {
        Autore autore = autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setDataDiNascita(autoreRequest.getDataDiNascita());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    public void delete(Long id) {
        Autore autore = autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
        autoreRepository.deleteById(id);
    }
}
