package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record NuovaPrenotazioneMandataDTO(

        @NotBlank
        @Size(min = 3, max = 30, message = "La destinazione deve avere tra 3 e 30 caratteri.")
        String viaggioId,

        @NotBlank
        @Size(min = 3, max = 30, message = "La partenza deve avere tra 3 e 30 caratteri.")
        String dipendenteId,
        
        @NotBlank
        @Future(message = "La data per cui vuoi prenotare deve essere futura.")
        LocalDate dataPrenotatoPer,
        
        String note
)
{

}
