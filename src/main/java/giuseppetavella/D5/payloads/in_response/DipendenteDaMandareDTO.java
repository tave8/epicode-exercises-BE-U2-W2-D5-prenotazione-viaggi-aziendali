package giuseppetavella.D5.payloads.in_response;

import giuseppetavella.D5.entities.Dipendente;

import java.time.LocalDate;
import java.util.UUID;

public class DipendenteDaMandareDTO {

    private final UUID dipendenteId;
    private final String nome;
    private final String cognome;
    private final String email;
    private final String avatarUrl;

    public DipendenteDaMandareDTO(Dipendente dipendente) {

        this.dipendenteId = dipendente.getDipendenteId();
        this.nome = dipendente.getNome();
        this.cognome = dipendente.getCognome();
        this.email = dipendente.getEmail();
        this.avatarUrl = dipendente.getAvatarUrl();

    }

    public UUID getDipendenteId() {
        return dipendenteId;
    }

    public String getCognome() {
        return cognome;
    }
    
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}

