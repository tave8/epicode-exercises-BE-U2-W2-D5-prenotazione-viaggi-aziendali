package giuseppetavella.D5.repositories;

import giuseppetavella.web_api_blogging_image_upload.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPost, UUID> {
    
    
    
}
