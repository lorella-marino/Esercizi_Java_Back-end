package it.epicode.s6_l2.autori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public List<AutoreResponse> findAll() {
        List<Autore> autoreList = autoreRepository.findAll();
        return autoreList.stream().map(autore -> new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome())).toList();
    }

    public AutoreResponse findById(Long id) {
        Autore autore = autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
    }

    public AutoreResponse create(AutoreRequest autoreRequest) {
        Autore autore = new Autore();
        autore.setNome(autoreRequest.getNome());
        autore.setCognome(autoreRequest.getCognome());
        autore.setEmail(autoreRequest.getEmail());
        autore.setDataDiNascita(autoreRequest.getDataDiNascita());
        autore.setAvatar(autoreRequest.getAvatar());
        autoreRepository.save(autore);
        return new AutoreResponse(autore.getId(), autore.getNome() + " " + autore.getCognome());
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
