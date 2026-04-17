package giuseppetavella.D5.payloads.in_response;

import giuseppetavella.web_api_blogging_image_upload.entities.BlogPost;

import java.util.UUID;

public class BlogPostToSendDTO {
    
    private final UUID authorId;
    private final String titolo;
    private final String categoria;
    private final String contenuto;
    private final int tempoDiLettura;
    // private final String CAMPO_CUSTOM = "sdasdaass";
    
    public BlogPostToSendDTO(BlogPost blogPost) {
        
        this.authorId = blogPost.getBlogPostId();
        this.titolo = blogPost.getTitolo();
        this.categoria = blogPost.getCategoria();
        this.contenuto = blogPost.getContenuto();
        this.tempoDiLettura = blogPost.getTempoDiLettura();
        
        
    }

    // public String getCAMPO_CUSTOM() {
    //     return CAMPO_CUSTOM;
    // }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getContenuto() {
        return contenuto;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }
}

