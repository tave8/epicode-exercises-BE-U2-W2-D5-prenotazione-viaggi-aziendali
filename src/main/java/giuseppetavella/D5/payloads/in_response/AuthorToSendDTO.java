package giuseppetavella.D5.payloads.in_response;

import giuseppetavella.web_api_blogging_image_upload.entities.Author;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public class AuthorToSendDTO {
    
    private final UUID authorId;
    private final String nome;
    private final String cognome;
    private final String email;
    private final LocalDate dataNascita;
    private final String avatarUrl;

    public AuthorToSendDTO(Author author) {
        
        this.authorId = author.getAuthorId();
        this.nome = author.getNome();
        this.cognome = author.getCognome();
        this.email = author.getEmail();
        this.dataNascita = author.getDataNascita();
        this.avatarUrl = author.getAvatarUrl();
        
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}

