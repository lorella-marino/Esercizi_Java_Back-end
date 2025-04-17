package it.epicode.s6_l4.autori;

import it.epicode.s6_l4.common.CommonResponse;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public Page<AutoreResponse> findAll(@ParameterObject Pageable pageable) {
        return autoreService.findAll(pageable);
    }

    @GetMapping("/id")
    public AutoreResponse findById(Long id) {
        return autoreService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse create(@RequestBody @Valid AutoreRequest autoreRequest) {
        return autoreService.create(autoreRequest);
    }

    @PatchMapping(path = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadAvatar (@RequestParam Long id, @RequestParam MultipartFile file) {
        autoreService.uploadAvatar(id, file);
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
