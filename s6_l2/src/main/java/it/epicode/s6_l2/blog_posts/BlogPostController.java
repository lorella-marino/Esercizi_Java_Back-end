package it.epicode.s6_l2.blog_posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List <BlogPostResponse> findAll() {
        return blogPostService.findAll();
    }

    @GetMapping("/id")
    public BlogPostResponse findById(Long id) {
        return blogPostService.findById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public BlogPostResponse create(BlogPostRequest blogPostRequest) {
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
