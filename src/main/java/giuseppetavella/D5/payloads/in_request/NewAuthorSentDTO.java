package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewAuthorSentDTO(
        @NotBlank
        @Size(min = 2, max = 30, message = "Il nome dell'autore deve avere tra 2 e 30 caratteri.")
        String nome,

        @NotBlank
        @Size(min = 2, max = 30, message = "Il cognome dell'autore deve avere tra 2 e 30 caratteri.")
        String cognome, 
        
        @Email(message = "L'email deve essere una email valida.")
        String email, 
        
        @Past(message = "La data di nascita deve essere passata.")
        LocalDate dataNascita) 
{

}
