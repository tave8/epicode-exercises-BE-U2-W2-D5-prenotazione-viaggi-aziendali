package giuseppetavella.D5.payloads.in_request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.cfg.defs.UUIDDef;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

public record NuovaPrenotazioneMandataDTO(

        @UUID(message = "viaggioId deve essere un valido UUID.")
        @NotBlank(message = "Manca il campo viaggioId.")
        String viaggioId,

        @UUID(message = "dipendenteId deve essere un valido UUID.")
        @NotBlank(message = "Manca il campo dipendenteId.")
        String dipendenteId,
        
        @NotNull(message = "Manca il campo dataPerCuiPrenotare.")
        @Future(message = "La data per cui vuoi prenotare deve essere futura.")
        LocalDate dataPerCuiPrenotare,
        
        String note
)
{

}
