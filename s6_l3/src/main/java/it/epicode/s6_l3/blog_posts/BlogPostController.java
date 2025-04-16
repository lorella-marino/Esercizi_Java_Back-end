package it.epicode.s6_l3.blog_posts;

import it.epicode.s6_l3.common.CommonResponse;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

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
    public CommonResponse create(@RequestBody @Valid BlogPostRequest blogPostRequest) {
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
