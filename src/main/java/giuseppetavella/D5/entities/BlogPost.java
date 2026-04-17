package giuseppetavella.D5.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue
    @Column(name = "blog_post_id")
    private UUID blogPostId;
    
    // foreign key: N blog posts ---belong to--> 1 author
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
    @Column(nullable = false)
    private String categoria;
    
    @Column(nullable = false)
    private String titolo;

    @Column(nullable = false)
    private String contenuto;

    @Column(name = "tempo_di_lettura", nullable = false)
    private int tempoDiLettura;
    
    @Column(name = "cover_url", nullable = false)
    private String coverUrl;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    protected BlogPost() {}

    public BlogPost(Author author, String titolo, String categoria, String contenuto, int tempoDiLettura) {
        this.setAuthor(author);
        this.setTitolo(titolo);
        this.setCategoria(categoria);
        this.setContenuto(contenuto);
        this.setTempoDiLettura(tempoDiLettura);
        this.setDefaultCoverUrl();
        this.createdAt = LocalDateTime.now();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public UUID getBlogPostId() {
        return blogPostId;
    }


    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    
    public void setDefaultCoverUrl() {
        this.setCoverUrl(this.getDefaultCoverUrl());
    }

    public String getDefaultCoverUrl() {
        return "https://fastly.picsum.photos/id/217/200/300.jpg?hmac=3GPQ-pPnL4D8miCKA0qNqIg4zr5Ponvl9OVH83CeGuc";
    }
    
    @Override
    public String toString() {
        return "BlogPost{" +
                "author=" + author +
                ", blogPostId=" + blogPostId +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
