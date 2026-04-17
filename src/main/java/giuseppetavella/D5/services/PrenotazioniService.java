package giuseppetavella.D5.services;


import com.cloudinary.Cloudinary;
import giuseppetavella.D5.entities.Dipendente;
import giuseppetavella.D5.entities.Prenotazione;
import giuseppetavella.D5.entities.Viaggio;
import giuseppetavella.D5.exceptions.CaricamentoFileException;
import giuseppetavella.D5.exceptions.NonTrovatoException;
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

    // public PrenotazioneDaMandareDTO aggiungiNuovaPrenotazione(NuovaPrenotazioneMandataDTO body) {
    //    
    //     // l'utente esiste?
    //     Dipendente dipendente = this.dipendentiService.findById(body.dipendenteId());
    //    
    //     // il viaggio esiste?
    //     Viaggio viaggio = this.viaggiService.
    //    
    //    
    //     Prenotazione nuovaPrenotazione = new Prenotazione(
    //             body.partenza(),
    //             body.destinazione()
    //     );
    //
    //     this.prenotazioniRepository.save(nuovaPrenotazione);
    //
    //     return new PrenotazioneDaMandareDTO(nuovaPrenotazione);
    // }


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
