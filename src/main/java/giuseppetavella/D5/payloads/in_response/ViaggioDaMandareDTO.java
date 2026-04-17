package giuseppetavella.D5.payloads.in_response;

import giuseppetavella.D5.entities.Viaggio;

import java.time.LocalDate;
import java.util.UUID;

public class ViaggioDaMandareDTO {

    private final UUID viaggioId;
    private final String partenza;
    private final String destinazione;

    public ViaggioDaMandareDTO(Viaggio viaggio) {

        this.viaggioId = viaggio.getViaggioId();
        this.partenza = viaggio.getPartenza();
        this.destinazione = viaggio.getDestinazione();

    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getPartenza() {
        return partenza;
    }

    public UUID getViaggioId() {
        return viaggioId;
    }
}

