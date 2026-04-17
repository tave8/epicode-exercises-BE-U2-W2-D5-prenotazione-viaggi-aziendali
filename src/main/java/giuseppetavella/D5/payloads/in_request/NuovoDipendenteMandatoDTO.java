package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NuovoDipendenteMandatoDTO(
        
        @NotBlank
        @Size(min = 2, max = 30, message = "Il nome del dipendente deve avere tra 2 e 30 caratteri")
        String nome,

        @NotBlank
        @Size(min = 2, max = 30, message = "Il cognome del dipendente deve avere tra 2 e 30 caratteri.")
        String cognome, 

        @Email(message = "L'email deve essere una email valida.")
        String email,
        
        @NotBlank
        @Size(min = 4, max = 20, message = "Lo username deve avere tra 4 e 20 caratteri.")
        String username
) 
{

}
