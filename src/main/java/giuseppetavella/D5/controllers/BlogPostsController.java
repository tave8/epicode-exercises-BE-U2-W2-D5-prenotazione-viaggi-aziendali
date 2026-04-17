package giuseppetavella.D5.controllers;


import giuseppetavella.web_api_blogging_image_upload.entities.BlogPost;
import giuseppetavella.web_api_blogging_image_upload.exceptions.PayloadValidationException;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_response.BlogPostToSendDTO;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_request.NewBlogPostSentDTO;
import giuseppetavella.web_api_blogging_image_upload.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    public Page<BlogPostToSendDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           // FIX: il default value deve essere l'attributo dell'oggetto.
                                           // prima avevo scritto created_at e mi dice che "non trovava
                                           // la proprietà created sull'entità BlogPost". era un messaggio di errore non corretto,
                                           // perché sembra si fosse dimenticato la parte dopo l'underscore (_at)
                                           @RequestParam(defaultValue = "createdAt") String sortBy) {
        return this.blogPostsService.findAllAsPayload(page, size, sortBy);
    }

    @GetMapping("/{blogPostId}")
    public BlogPostToSendDTO findById(@PathVariable UUID blogPostId) {
        BlogPost blogPost = this.blogPostsService.findById(blogPostId);
        return new BlogPostToSendDTO(blogPost);
    }
    
    // fare un payload custom per blog post e ritornare quello

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BlogPostToSendDTO addNewBlogPost(@RequestBody @Validated NewBlogPostSentDTO body, 
                                   BindingResult validationResult) 
    {
        
        if(validationResult.hasErrors()) {
            //     TODO: throw payload validation exception
            List<String> errors = validationResult
                                    .getFieldErrors()
                                    .stream().map(fieldError -> fieldError.getDefaultMessage())
                                    .toList();
            
            throw new PayloadValidationException(errors);
        }
        
        return this.blogPostsService.saveNewBlogPost(body);
    }
    //
    // @PutMapping("/{blogPostId}")
    // public BlogPost update(@PathVariable String blogPostId, @RequestBody NewBlogPostPayload body) {
    //     return blogPostsService.update(blogPostId, body);
    // }
    //
    //
    // @DeleteMapping("/{blogPostId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete(@PathVariable String blogPostId) {
    //     blogPostsService.delete(blogPostId);
    // }

}
