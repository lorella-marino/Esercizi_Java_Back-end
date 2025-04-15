package it.epicode.s6_l2.autori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public List<AutoreResponse> findAll() {
        return autoreService.findAll();
    }

    @GetMapping("/id")
    public AutoreResponse findById(Long id) {
        return autoreService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreResponse create(AutoreRequest autoreRequest) {
        return autoreService.create(autoreRequest);
    }

    @PutMapping("/{id}")
    public AutoreResponse update(@PathVariable Long id, @RequestBody AutoreRequest autoreRequest) {
        return autoreService.update(id, autoreRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
