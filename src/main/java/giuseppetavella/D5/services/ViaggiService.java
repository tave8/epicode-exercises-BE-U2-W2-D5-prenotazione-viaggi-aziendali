package giuseppetavella.D5.services;


import com.cloudinary.Cloudinary;
import giuseppetavella.D5.entities.Dipendente;
import giuseppetavella.D5.entities.Viaggio;
import giuseppetavella.D5.exceptions.CaricamentoFileException;
import giuseppetavella.D5.exceptions.NonTrovatoException;
import giuseppetavella.D5.payloads.in_request.NuovoDipendenteMandatoDTO;
import giuseppetavella.D5.payloads.in_request.NuovoViaggioMandatoDTO;
import giuseppetavella.D5.payloads.in_response.DipendenteDaMandareDTO;
import giuseppetavella.D5.payloads.in_response.ViaggioDaMandareDTO;
import giuseppetavella.D5.repositories.DipendentiRepository;
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
public class ViaggiService {

    @Autowired
    private ViaggiRepository viaggiRepository;

    @Autowired
    private Cloudinary cloudinaryUploader;

    public List<ViaggioDaMandareDTO> findAll() {
        return this.viaggiRepository
                .findAll()
                .stream()
                .map(viaggio -> new ViaggioDaMandareDTO(viaggio))
                .toList();
    }

    public ViaggioDaMandareDTO aggiungiNuovoViaggio(NuovoViaggioMandatoDTO body) {

        Viaggio nuovoViaggio = new Viaggio(
                body.partenza(),
                body.destinazione()
        );

        this.viaggiRepository.save(nuovoViaggio);

        return new ViaggioDaMandareDTO(nuovoViaggio);
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

    // public Dipendente findById(UUID dipendenteId) throws NonTrovatoException {
    //     Optional<Dipendente> maybeDipendente = this.dipendentiRepository.findById(dipendenteId);
    //
    //     if (maybeDipendente.isEmpty()) {
    //         throw new NonTrovatoException(dipendenteId, "DIPENDENTE");
    //     }
    //
    //     return maybeDipendente.get();
    // }
    //
    //
    //
    // public DipendenteDaMandareDTO uploadAvatarImage(UUID dipendenteId,
    //                                                 MultipartFile avatarImage) throws NonTrovatoException {
    //     //   check that the file is an actual image
    //
    //     //   find author
    //     Dipendente dipendente = this.findById(dipendenteId);
    //
    //     String avatarUrlAfterUpload;
    //
    //     try {
    //         // upload image to cloudinary
    //         Map result = cloudinaryUploader
    //                 .uploader()
    //                 // get the bytes of the file. 
    //                 // this is what we're going to upload to cloudinary
    //                 .upload(avatarImage.getBytes(), Map.of());
    //
    //         avatarUrlAfterUpload = (String) result.get("secure_url");
    //
    //     } catch (IOException | RuntimeException ex) {
    //         throw new CaricamentoFileException(ex.getMessage());
    //     }
    //
    //     // get image url, if success
    //
    //     // System.out.println(avatarUrlAfterUpload);
    //
    //     // update author (with setter)
    //     dipendente.setAvatarUrl(avatarUrlAfterUpload);
    //
    //     // save user      
    //     return this.aggiornaDipendente(dipendente);
    //
    // }

}
