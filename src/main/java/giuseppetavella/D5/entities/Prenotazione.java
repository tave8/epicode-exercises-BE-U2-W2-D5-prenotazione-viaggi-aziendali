package giuseppetavella.D5.entities;

import giuseppetavella.D5.enums.StatoPrenotazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    
    @Id
    @GeneratedValue
    @Column(name = "prenotazione_id")
    private UUID prenotazioneId;
    
    
    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    private Viaggio viaggio;
    
    
    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;
    
    
    @Column(name = "data_prenotato_per", nullable = false)
    private LocalDate dataPrenotatoPer;

    @Column(name = "data_prenotato_il", nullable = false)
    private LocalDate dataPrenotatoIl;
    
    
    @Column(name = "stato_prenotazione", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoPrenotazione statoPrenotazione;
    
    
    @Column(nullable = false)
    private String note;
    
    
    protected Prenotazione() {}
    
    public Prenotazione(Viaggio viaggio,
                        Dipendente dipendente,
                        LocalDate dataPrenotatoPer,
                        String note)
    {
        this.viaggio = viaggio;
        this.dipendente = dipendente;
        this.dataPrenotatoPer = dataPrenotatoPer;
        this.dataPrenotatoIl = LocalDate.now();
        this.setNote(note);
        this.setStatoPrenotazione(StatoPrenotazione.IN_PROGRAMMA);
    }
    
    public Prenotazione(Viaggio viaggio, 
                        Dipendente dipendente,
                        LocalDate dataPrenotatoPer) 
    {
        this(viaggio, dipendente, dataPrenotatoPer, "");
    }


    public LocalDate getDataPrenotatoIl() {
        return dataPrenotatoIl;
    }
    

    public LocalDate getDataPrenotatoPer() {
        return dataPrenotatoPer;
    }
    

    public Dipendente getDipendente() {
        return dipendente;
    }
    

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UUID getPrenotazioneId() {
        return prenotazioneId;
    }
    
    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }


    @Override
    public String toString() {
        return "Prenotazione{" +
                "dataPrenotatoPer=" + dataPrenotatoPer +
                ", prenotazioneId=" + prenotazioneId +
                ", viaggio=" + viaggio +
                ", dipendente=" + dipendente +
                '}';
    }
}
