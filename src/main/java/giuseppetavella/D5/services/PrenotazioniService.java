package giuseppetavella.D5.services;


import com.cloudinary.Cloudinary;
import giuseppetavella.D5.entities.Dipendente;
import giuseppetavella.D5.entities.Prenotazione;
import giuseppetavella.D5.entities.Viaggio;
import giuseppetavella.D5.exceptions.CaricamentoFileException;
import giuseppetavella.D5.exceptions.NonTrovatoException;
import giuseppetavella.D5.exceptions.PrenotazioneNonDisponibileException;
import giuseppetavella.D5.exceptions.ValidazionePayloadException;
import giuseppetavella.D5.payloads.in_request.NuovaPrenotazioneMandataDTO;
import giuseppetavella.D5.payloads.in_request.NuovoDipendenteMandatoDTO;
import giuseppetavella.D5.payloads.in_request.NuovoViaggioMandatoDTO;
import giuseppetavella.D5.payloads.in_response.DipendenteDaMandareDTO;
import giuseppetavella.D5.payloads.in_response.PrenotazioneDaMandareDTO;
import giuseppetavella.D5.payloads.in_response.ViaggioDaMandareDTO;
import giuseppetavella.D5.repositories.DipendentiRepository;
import giuseppetavella.D5.repositories.PrenotazioniRepository;
import giuseppetavella.D5.repositories.ViaggiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioniService {

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    
    @Autowired
    private DipendentiService dipendentiService;
    
    @Autowired
    private ViaggiService viaggiService;
    

    // public List<ViaggioDaMandareDTO> findAll() {
    //     return this.viaggiRepository
    //             .findAll()
    //             .stream()
    //             .map(viaggio -> new ViaggioDaMandareDTO(viaggio))
    //             .toList();
    // }

    public PrenotazioneDaMandareDTO aggiungiNuovaPrenotazione(NuovaPrenotazioneMandataDTO body) throws PrenotazioneNonDisponibileException, 
                                                                                                        NonTrovatoException 
    {
        Dipendente dipendente;
        Viaggio viaggio;
        
        // OTTIENI DIPENDENTE & VIAGGIO
        
        try {
            // l'utente esiste?
            dipendente = this.dipendentiService.findById(UUID.fromString(body.dipendenteId()));
            
            // il viaggio esiste?
            viaggio = this.viaggiService.findById(UUID.fromString(body.viaggioId()));
            
        }  catch (IllegalArgumentException ex) {
            throw new ValidazionePayloadException("gli ID devono essere valide stringhe UUID.");
        }
        
        // siccome abbiamo creato un oggetto java non ancora dall'ORM
        // significa che questa non è una vera prenotazione nel DB, ma
        // un oggetto java, appunto. quindi avrà il suo campo ID nullo
        Prenotazione potenzialePrenotazione = new Prenotazione(
                viaggio,
                dipendente,
                body.dataPerCuiPrenotare()
        );
        
        // VERIFICA SE DIPENDENTE PUO' PRENOTARE PER DATA
        if(!this.puoPrenotare(potenzialePrenotazione)) {
            throw new PrenotazioneNonDisponibileException(dipendente.getDipendenteId(), body.dataPerCuiPrenotare());
        }
        
        
        // AGGIUNGI LA PRENOTAZIONE
        this.prenotazioniRepository.save(potenzialePrenotazione);
        
        
        return new PrenotazioneDaMandareDTO(potenzialePrenotazione);

    }
    
    
    boolean puoPrenotare(Prenotazione potenzialePrenotazione) {
        
        // caso in cui l'ID della prenotazione esiste già:
        // si assume che questo significhi che la prenotazione è già in database,
        // per qualche motivo
        if(potenzialePrenotazione.getPrenotazioneId() != null) {
            throw new PrenotazioneNonDisponibileException(
                    // ID dipendente
                    potenzialePrenotazione.getDipendente().getDipendenteId(), 
                    // data per cui prenotare
                    potenzialePrenotazione.getDataPrenotatoPer(),
                    // dettagli
                    "Questa prenotazione ha un ID non nullo con valore '" 
                            + potenzialePrenotazione.getPrenotazioneId() 
                            + "' e questo non può verificarsi. Una POTENZIALE prenotazione non può avere un ID. "
                            +"Accertarsi che la prenotazione non sia già nel database."
            );
        }
        
        return this.prenotazioniRepository.puoPrenotare(
                potenzialePrenotazione.getDipendente().getDipendenteId(),
                // per "data prenotato per" si intende la data per cui si 
                // desidera prenotare
                potenzialePrenotazione.getDataPrenotatoPer()
        );
        
    }


    // public AuthorToSendDTO updateAuthor(UUID authorId, NewAuthorPayload body) {
    //    
    //     // Author author = this.findOne(authorIdStr);
    //     //
    //     // author.setNome(body.getNome());
    //     // author.setCognome(body.getCognome());
    //     // author.setEmail(body.getEmail());
    //     // author.setDataNascita(body.getDataNascita());
    //     //
    //     // return author;
    // }

    // public DipendenteDaMandareDTO aggiornaDipendente(Dipendente dipendente) {
    //     Dipendente dipendenteAggiornato = this.dipendentiRepository.save(dipendente);
    //     return new DipendenteDaMandareDTO(dipendenteAggiornato);
    // }


    //
    //
    // public Author delete(String authorIdStr) {
    //     Author author = this.findOne(authorIdStr);
    //
    //     this.authors.remove(author);
    //
    //     return author;
    // }
    //
    //
    //

    //
    //
 

}
