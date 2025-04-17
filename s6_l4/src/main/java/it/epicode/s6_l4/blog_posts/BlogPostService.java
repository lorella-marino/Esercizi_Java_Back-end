package it.epicode.s6_l4.blog_posts;

import it.epicode.s6_l4.autori.Autore;
import it.epicode.s6_l4.autori.AutoreRepository;
import it.epicode.s6_l4.cloudinary.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

@Service
@Validated
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public void uploadCover(Long id, MultipartFile file) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BlogPost non trovato"));
        String coverUrl = cloudinaryService.uploadImage(file);
        blogPost.setCover(coverUrl);
        blogPostRepository.save(blogPost);
    }

    public BlogPostResponse create(@Valid BlogPostRequest blogPostRequest) {
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPost.setTempoDiLettura(blogPostRequest.getTempoDiLettura());
        blogPost.setCategoria(blogPostRequest.getCategoria());
        blogPost.setContenuto(blogPostRequest.getContenuto());
        blogPost.setTitolo(blogPostRequest.getTitolo());
        blogPost.setCover(blogPostRequest.getCover());
        blogPost.setAutore(autoreRepository.findById(blogPostRequest.getAutoreId()).orElseThrow(() -> new RuntimeException("Autore non trovato")));
        blogPostRepository.save(blogPost);
        return toResponse(blogPost);
    }

    public BlogPostResponse toResponse(BlogPost blogPost) {
        BlogPostResponse blogPostResponse = new BlogPostResponse();
        BeanUtils.copyProperties (blogPost, blogPostResponse);
        blogPostResponse.setAutoreId(blogPost.getAutore().getId());
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

        blogPostResponse.setAutoreId(blogPost.getAutore().getId());
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
