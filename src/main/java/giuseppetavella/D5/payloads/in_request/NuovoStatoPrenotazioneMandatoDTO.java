package giuseppetavella.D5.payloads.in_request;

import giuseppetavella.D5.enums.StatoPrenotazione;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record NuovoStatoPrenotazioneMandatoDTO(

        @NotNull(message = "Manca il nuovo stato della prenotazione.")
        @NotEmpty(message = "Il nuovo stato della prenotazione non può essere vuoto.")
        String statoPrenotazione
        
)
{

}
