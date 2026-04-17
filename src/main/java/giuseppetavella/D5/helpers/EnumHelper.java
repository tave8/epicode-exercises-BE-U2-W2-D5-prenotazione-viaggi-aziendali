package giuseppetavella.D5.helpers;

import giuseppetavella.D5.enums.StatoPrenotazione;

public class EnumHelper {

    /**
     * Verifica che lo stato prenotazione esista veramente.
     * Utile per validare con i body delle richieste.
     */
    public static boolean statoPrenotazioneEValido(String statoPrenotazioneTargetComeStr) {
        
        try {
            StatoPrenotazione.valueOf(statoPrenotazioneTargetComeStr);
            return true;
        } 
        // conversione fallita = la stringa non può essere convertita a 
        // questo valido enum
        catch(IllegalArgumentException ex) {
            
            return false;
        
        }
        
        
    }
    
}
