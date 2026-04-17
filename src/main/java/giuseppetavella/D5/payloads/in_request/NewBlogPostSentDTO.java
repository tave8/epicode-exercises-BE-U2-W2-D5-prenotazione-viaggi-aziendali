package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * Class representing a new blog post sent as payload.
 */
public record NewBlogPostSentDTO(
        @NotNull(message = "Manca l'ID dell'autore.")
        UUID authorId, 
        
        @Size(min = 5, max = 30, message = "Il titolo deve avere tra 5 e 30 caratteri.")
        String titolo,
        
        String categoria,
        
        String contenuto,
        
        @Positive(message = "Il tempo di lettura deve essere un numero positivo.")
        int tempoDiLettura) 
{


}
