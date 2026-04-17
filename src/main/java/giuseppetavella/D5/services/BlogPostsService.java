package giuseppetavella.D5.services;


import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import giuseppetavella.web_api_blogging_image_upload.entities.BlogPost;
import giuseppetavella.web_api_blogging_image_upload.exceptions.NotFoundException;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_response.BlogPostToSendDTO;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_request.NewBlogPostSentDTO;
import giuseppetavella.web_api_blogging_image_upload.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BlogPostsService {

    @Autowired
    private BlogPostsRepository blogPostsRepository;
    
    @Autowired
    private AuthorsService authorsService;
    

    public Page<BlogPost> findAll(int page, int size, String sortBy) {
        // the size of each page (how many elements in each page)
        int finalSize = Math.min(10, size);
        // the page number
        int finalPage = Math.max(0, page);
        // page is the function that will get translated to SQL,
        // that will in turn filter the result set
        Pageable pageable = PageRequest.of(finalPage, finalSize, Sort.by(sortBy));
        // fare map tra gli oggetti del content e quello che voglio tornare (rappresentazione)
        return this.blogPostsRepository.findAll(pageable);
    }

    public Page<BlogPostToSendDTO> findAllAsPayload(int page, int size, String sortBy) {
       Page<BlogPost> blogPosts = this.findAll(page, size, sortBy);
       return blogPosts.map(blogPost -> new BlogPostToSendDTO(blogPost));
    }
    
    
    

    public BlogPostToSendDTO saveNewBlogPost(NewBlogPostSentDTO body) throws NotFoundException {
        // fai i controlli qui dentro
        
        // prima di aggiungere il blog post, trova l'autore,
       //  se esiste
       Author author = this.authorsService.findById(body.authorId());
        
        BlogPost newBlogPost = new BlogPost(
                author,
                body.titolo(),
                body.categoria(),
                body.contenuto(),
                body.tempoDiLettura()
        );

        this.blogPostsRepository.save(newBlogPost);
        
        return new BlogPostToSendDTO(newBlogPost);
    }

    // public BlogPost update(String blogPostIdStr, NewBlogPostPayload body) {
    //     BlogPost blogPost = this.findOne(blogPostIdStr);
    //
    //     blogPost.setTitolo(body.getTitolo());
    //     blogPost.setCategoria(body.getCategoria());
    //     blogPost.setContenuto(body.getContenuto());
    //     blogPost.setTempoDiLettura(body.getTempoDiLettura());
    //
    //     return blogPost;
    // }
    //
    //
    // public BlogPost delete(String blogPostIdStr) {
    //     BlogPost blogPost = this.findOne(blogPostIdStr);
    //
    //     this.blogPosts.remove(blogPost);
    //
    //     return blogPost;
    // }
    


    public BlogPost findById(UUID blogPostId) {
        Optional<BlogPost> maybeBlogPost = this.blogPostsRepository.findById(blogPostId);

        if (maybeBlogPost.isEmpty()) {
            throw new NotFoundException(blogPostId, "blog post");
        }

        return maybeBlogPost.get();
    }

}
