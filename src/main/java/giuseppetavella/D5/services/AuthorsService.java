package giuseppetavella.D5.services;


import com.cloudinary.Cloudinary;
import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import giuseppetavella.web_api_blogging_image_upload.exceptions.NotFoundException;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_request.NewAuthorSentDTO;
import giuseppetavella.web_api_blogging_image_upload.payloads.in_response.AuthorToSendDTO;
import giuseppetavella.web_api_blogging_image_upload.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorsService {
    
    @Autowired
    private AuthorsRepository authorsRepository;
    
    @Autowired
    private Cloudinary cloudinaryUploader;
    
    public List<AuthorToSendDTO> findAll() {
        return this.authorsRepository
                .findAll()
                .stream()
                .map(author -> new AuthorToSendDTO(author))
                .toList();
    }
    
    public AuthorToSendDTO addNewAuthor(NewAuthorSentDTO body) {
        // fai le verifiche qui prima di aggiungere l'autore
        
        Author newAuthor = new Author(
                body.nome(),
                body.cognome(),
                body.email(),
                body.dataNascita()
        );

        this.authorsRepository.save(newAuthor);
        
        return new AuthorToSendDTO(newAuthor);
    }
    
    
    // public AuthorToSendDTO updateAuthor(UUID authorId, NewAuthorPayload body) {
    //    
    //     // Author author = this.findOne(authorIdStr);
    //     //
    //     // author.setNome(body.getNome());
    //     // author.setCognome(body.getCognome());
    //     // author.setEmail(body.getEmail());
    //     // author.setDataNascita(body.getDataNascita());
    //     //
    //     // return author;
    // }
    
    public AuthorToSendDTO updateAuthor(Author author) {
        Author updatedAuthor = this.authorsRepository.save(author);
        return new AuthorToSendDTO(updatedAuthor);
    }
    
    
    //
    //
    // public Author delete(String authorIdStr) {
    //     Author author = this.findOne(authorIdStr);
    //
    //     this.authors.remove(author);
    //
    //     return author;
    // }
    //
    //
    //
    
    public Author findById(UUID authorId) throws NotFoundException {
        Optional<Author> maybeAuthor = this.authorsRepository.findById(authorId);
        
        if (maybeAuthor.isEmpty()) {
            throw new NotFoundException(authorId, "autore");
        }
        
        return maybeAuthor.get();
    }
    
    
    
    public AuthorToSendDTO uploadAvatarImage(UUID authorId, 
                                            MultipartFile avatarImage) throws NotFoundException {
        //   check that the file is an actual image
        
        //   find author
        Author author = this.findById(authorId);
        
        String avatarUrlAfterUpload;
        
        try {
            // upload image to cloudinary
            Map result = cloudinaryUploader
                    .uploader()
                    // get the bytes of the file. 
                    // this is what we're going to upload to cloudinary
                    .upload(avatarImage.getBytes(), Map.of());
            
            avatarUrlAfterUpload = (String) result.get("secure_url");
            
        } catch (IOException ex) {
            throw new RuntimeException("error uploading avatar image");
        }
        
        // get image url, if success

        // System.out.println(avatarUrlAfterUpload);
        
        // update author (with setter)
        author.setAvatarUrl(avatarUrlAfterUpload);
        
        // save user      
        return this.updateAuthor(author);
        
    }
    
}
