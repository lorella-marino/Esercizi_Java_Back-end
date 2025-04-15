package it.epicode.s6_l2.blog_posts;

import it.epicode.s6_l2.autori.AutoreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreRepository autoreRepository;

    public BlogPostResponse create(BlogPostRequest blogPostRequest) {
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPost.setAutore(autoreRepository.findById(blogPostRequest.getAutoreId()).orElseThrow(() -> new RuntimeException("Autore non trovato")));
        blogPostRepository.save(blogPost);
        return toResponse(blogPost);
    }

    public BlogPostResponse toResponse(BlogPost blogPost) {
        BlogPostResponse blogPostResponse = new BlogPostResponse();
        BeanUtils.copyProperties (blogPost, blogPostResponse);
        blogPostResponse.setAutore(blogPost.getAutore().getNome()+ " " + blogPost.getAutore().getCognome());
        return blogPostResponse;
    }

    public List<BlogPostResponse> findAll() {
        List<BlogPost> blogPostList = blogPostRepository.findAll();
        return blogPostList.stream().map(this::toResponse).toList();
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
