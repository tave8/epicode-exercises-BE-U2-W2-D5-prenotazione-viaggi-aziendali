package giuseppetavella.D5.exceptions;

import java.time.LocalDate;
import java.util.UUID;

public class PrenotazioneNonDisponibileException extends RuntimeException {
    public PrenotazioneNonDisponibileException(UUID dipendenteId, LocalDate dataPerCuiPrenotare, String details) {
        super("L'utente con ID " + dipendenteId + " non può prenotare per " + dataPerCuiPrenotare + ". DETTAGLI: " + details);
    }
    
    public PrenotazioneNonDisponibileException(UUID dipendenteId, LocalDate dataPerCuiPrenotare) {
        super("L'utente con ID " + dipendenteId + " non può prenotare per " + dataPerCuiPrenotare);
    }
}
