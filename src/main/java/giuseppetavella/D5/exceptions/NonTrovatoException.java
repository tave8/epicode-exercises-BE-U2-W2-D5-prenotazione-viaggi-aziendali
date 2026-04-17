package giuseppetavella.D5.exceptions;

import java.util.UUID;

public class NonTrovatoException extends RuntimeException {
    public NonTrovatoException(UUID id) {
        super("L'elemento con ID " + id + " non è stato trovato.");
    }

    public NonTrovatoException(UUID id, String informalEntity) {
        super("L'elemento '" + informalEntity + "' con ID " + id + " non è stato trovato.");
    }
}
