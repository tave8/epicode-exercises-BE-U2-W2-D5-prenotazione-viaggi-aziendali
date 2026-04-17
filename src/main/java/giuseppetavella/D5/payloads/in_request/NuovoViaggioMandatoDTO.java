package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NuovoViaggioMandatoDTO(

        @NotBlank(message = "Manca il campo destinazione.")
        @Size(min = 3, max = 30, message = "La destinazione deve avere tra 3 e 30 caratteri.")
        String destinazione,

        @NotBlank(message = "Manca il campo partenza.")
        @Size(min = 3, max = 30, message = "La partenza deve avere tra 3 e 30 caratteri.")
        String partenza
)
{

}
