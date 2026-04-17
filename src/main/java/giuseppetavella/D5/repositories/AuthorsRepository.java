package giuseppetavella.D5.repositories;

import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, UUID> {
    
    
    
}
