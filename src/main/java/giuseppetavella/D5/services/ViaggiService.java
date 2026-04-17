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

    

    public Viaggio findById(UUID viaggioId) throws NonTrovatoException {
        Optional<Viaggio> maybeViaggio = this.viaggiRepository.findById(viaggioId);

        if (maybeViaggio.isEmpty()) {
            throw new NonTrovatoException(viaggioId, "VIAGGIO");
        }

        return maybeViaggio.get();
    }

}
