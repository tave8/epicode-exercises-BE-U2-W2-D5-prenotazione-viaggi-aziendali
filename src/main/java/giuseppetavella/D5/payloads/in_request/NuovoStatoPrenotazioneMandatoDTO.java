package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record NuovoStatoPrenotazioneMandatoDTO(

        @NotBlank
        @NotEmpty(message = "Il nuovo stato della prenotazione non può essere vuoto.")
        String statoPrenotazione
        
)
{

}
