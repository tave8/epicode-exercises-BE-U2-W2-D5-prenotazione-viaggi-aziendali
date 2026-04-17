package giuseppetavella.D5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    
    @Id
    @GeneratedValue
    private UUID viaggioId;
    
    @Column(nullable = false)
    private final String destinazione;
    
    @Column(nullable = false)
    private final String partenza;
    
    public Viaggio(String destinazione, String partenza) {
        this.destinazione = destinazione;
        this.partenza = partenza;
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

    @Override
    public String toString() {
        return "Viaggio{" +
                "destinazione='" + destinazione + '\'' +
                ", viaggioId=" + viaggioId +
                ", partenza='" + partenza + '\'' +
                '}';
    }
}
