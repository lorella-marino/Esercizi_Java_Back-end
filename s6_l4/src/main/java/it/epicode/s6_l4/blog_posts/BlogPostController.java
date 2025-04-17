package it.epicode.s6_l4.blog_posts;

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
@RequestMapping("/blog-posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PatchMapping (path = "/{id}/cover", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadCover(@PathVariable Long id, @RequestBody MultipartFile file) {
        blogPostService.uploadCover(id, file);
    }
    @GetMapping
    public Page<BlogPostResponse> findAll(@ParameterObject Pageable pageable) {
        return blogPostService.findAll(pageable);
    }

    @GetMapping("/id")
    public BlogPostResponse findById(Long id) {
        return blogPostService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public BlogPostResponse create(@RequestBody @Valid BlogPostRequest blogPostRequest) {
        return blogPostService.create(blogPostRequest);
    }

    @PutMapping("/{id}")
    public BlogPostResponse update(@PathVariable Long id, @RequestBody BlogPostRequest blogPostRequest) {
        return blogPostService.update(id, blogPostRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogPostService.delete(id);
    }
}
