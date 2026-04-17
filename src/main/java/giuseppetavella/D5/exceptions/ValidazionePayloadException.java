package giuseppetavella.D5.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * This exception is used for validations of payloads.
 * FLOW: 
 * 1. The HTTP request comes through 
 * 2. The Spring server intercepts it because a request handler has been
 *    attached to that endpoint
 * 3. Spring triggers the controller for this endpoint.
 * 4. Spring triggers the validation for this incoming payload, if any.
 * 5. Spring makes all the validation errors available.
 * 6. In the controller, we can check if there are any validation errors.
 * 7. If there's any validation error, in the sense that at least 1 validation
 *    in 1 field failed, then we can pass these errors list or string 
 *    to the relevant exception, by throwing this exception
 * 8. That's where this PayloadValidationException comes into play
 */
public class ValidazionePayloadException extends RuntimeException {
    private List<String> errors = new ArrayList<>();

    public ValidazionePayloadException(String message) {
        super(message);
    }

    public ValidazionePayloadException(List<String> errors) {
       super("Errore di validazione del payload: Almeno un campo non è valido..");
       this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
