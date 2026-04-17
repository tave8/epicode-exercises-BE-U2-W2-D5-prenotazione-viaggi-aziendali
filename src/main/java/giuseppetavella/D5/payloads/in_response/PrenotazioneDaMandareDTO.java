package giuseppetavella.D5.payloads.in_response;

import giuseppetavella.D5.entities.Prenotazione;
import giuseppetavella.D5.enums.StatoPrenotazione;

import java.time.LocalDate;
import java.util.UUID;

public class PrenotazioneDaMandareDTO {

    private final UUID prenotazioneId;
    private final UUID viaggioId;
    private final UUID dipendenteId;
    private final LocalDate dataPrenotatoPer;
    private final LocalDate dataPrenotatoIl;
    private final StatoPrenotazione statoPrenotazione;
    private final String note;

    public PrenotazioneDaMandareDTO(Prenotazione prenotazione) {

        this.prenotazioneId = prenotazione.getPrenotazioneId();
        this.viaggioId = prenotazione.getViaggio().getViaggioId();
        this.dipendenteId = prenotazione.getDipendente().getDipendenteId();
        this.dataPrenotatoPer = prenotazione.getDataPrenotatoPer();
        this.dataPrenotatoIl = prenotazione.getDataPrenotatoIl();
        this.statoPrenotazione = prenotazione.getStatoPrenotazione();
        this.note = prenotazione.getNote();

    }

    public LocalDate getDataPrenotatoIl() {
        return dataPrenotatoIl;
    }

    public UUID getDipendenteId() {
        return dipendenteId;
    }

    public LocalDate getDataPrenotatoPer() {
        return dataPrenotatoPer;
    }

    public String getNote() {
        return note;
    }

    public UUID getPrenotazioneId() {
        return prenotazioneId;
    }

    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public UUID getViaggioId() {
        return viaggioId;
    }
}

