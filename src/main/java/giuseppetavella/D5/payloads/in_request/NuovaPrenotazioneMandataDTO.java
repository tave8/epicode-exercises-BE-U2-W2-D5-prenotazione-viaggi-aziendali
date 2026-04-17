package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.cfg.defs.UUIDDef;

import java.time.LocalDate;
import java.util.UUID;

public record NuovaPrenotazioneMandataDTO(

        @NotBlank(message = "Manca il campo viaggioId.")
        @Size(min = 3, max = 30, message = "La destinazione deve avere tra 3 e 30 caratteri.")
        UUID viaggioId,

        @NotBlank(message = "Manca il campo dipendenteId.")
        @Size(min = 3, max = 30, message = "La partenza deve avere tra 3 e 30 caratteri.")
        UUID dipendenteId,
        
        @NotBlank(message = "Manca il campo dataPrenotatoPer.")
        @Future(message = "La data per cui vuoi prenotare deve essere futura.")
        LocalDate dataPrenotatoPer,
        
        String note
)
{

}
