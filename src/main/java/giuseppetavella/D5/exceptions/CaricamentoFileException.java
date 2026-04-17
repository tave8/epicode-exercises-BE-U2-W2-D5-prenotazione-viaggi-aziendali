package giuseppetavella.D5.exceptions;

public class CaricamentoFileException extends RuntimeException {
    public CaricamentoFileException(String message) {
        super("Errore durante il caricamento di un file. DETTAGLI: " + message);
    }
}
