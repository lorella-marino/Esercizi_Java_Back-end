package it.epicode.s6_l3.blog_posts;

import it.epicode.s6_l3.autori.AutoreRepository;
import it.epicode.s6_l3.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreRepository autoreRepository;

    public CommonResponse create(@Valid BlogPostRequest blogPostRequest) {
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPost.setAutore(autoreRepository.findById(blogPostRequest.getAutoreId()).orElseThrow(() -> new RuntimeException("Autore non trovato")));
        blogPostRepository.save(blogPost);
        return new CommonResponse(blogPost.getId());
    }

    public BlogPostResponse toResponse(BlogPost blogPost) {
        BlogPostResponse blogPostResponse = new BlogPostResponse();
        BeanUtils.copyProperties (blogPost, blogPostResponse);
        blogPostResponse.setAutore(blogPost.getAutore().getNome()+ " " + blogPost.getAutore().getCognome());
        return blogPostResponse;
    }

    public Page<BlogPostResponse> findAll(Pageable pageable) {
        Page<BlogPost> blogPostPage = blogPostRepository.findAll(pageable);
        return blogPostPage.map(this::toResponse);
    }

    public BlogPostResponse findById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost non trovato"));
        BlogPostResponse blogPostResponse = new BlogPostResponse();
        BeanUtils.copyProperties(blogPost, blogPostResponse);

        blogPostResponse.setAutore(blogPost.getAutore().getNome() + " " + blogPost.getAutore().getCognome());
        return blogPostResponse;
    }

    public BlogPostResponse update(Long id, BlogPostRequest blogPostRequest) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost non trovato"));
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPost.setAutore(autoreRepository.findById(blogPostRequest.getAutoreId()).orElseThrow(() -> new RuntimeException("Autore non trovato")));
        blogPostRepository.save(blogPost);
        return toResponse(blogPost);
    }

    public void delete(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost non trovato"));
        blogPostRepository.deleteById(id);
    }

}
