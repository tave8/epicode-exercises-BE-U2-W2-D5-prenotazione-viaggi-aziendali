package giuseppetavella.D5.exceptions;

public class NuovoStatoPrenotazioneNonValidoException extends RuntimeException {
    
    public NuovoStatoPrenotazioneNonValidoException(String msg) {
        super("Il nuovo stato di questa prenotazione non è valido. DETTAGLI: " + msg);
    }
    
}
