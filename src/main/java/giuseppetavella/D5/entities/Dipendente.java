package giuseppetavella.D5.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "dipendenti")
public class Dipendente {
    
    @Id
    @GeneratedValue
    @Column(name = "dipendente_id")
    private UUID dipendenteId;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cognome;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl;
    
    protected Dipendente() {}
    
    public Dipendente(String nome, 
                      String cognome, 
                      String email, 
                      String username) 
    {
        this.setNome(nome);
        this.setCognome(cognome);
        this.setEmail(email);
        this.setUsername(username);
        this.setDefaultAvatarUrl();
    }
    
    private void setDefaultAvatarUrl() {
        this.setAvatarUrl(this.getDefaultAvatarUrl());
    }
    
    private String getDefaultAvatarUrl() {
        String nomeCompleto = this.getNome() + "+" + this.getCognome();
        return "https://ui-avatars.com/api/?name=" + nomeCompleto;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public UUID getDipendenteId() {
        return dipendenteId;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                ", dipendenteId=" + dipendenteId +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
