package giuseppetavella.D5.controllers;


import giuseppetavella.D5.entities.Dipendente;
import giuseppetavella.D5.exceptions.ValidazionePayloadException;
import giuseppetavella.D5.payloads.in_request.NuovaPrenotazioneMandataDTO;
import giuseppetavella.D5.payloads.in_request.NuovoDipendenteMandatoDTO;
import giuseppetavella.D5.payloads.in_request.NuovoViaggioMandatoDTO;
import giuseppetavella.D5.payloads.in_response.DipendenteDaMandareDTO;
import giuseppetavella.D5.payloads.in_response.PrenotazioneDaMandareDTO;
import giuseppetavella.D5.payloads.in_response.ViaggioDaMandareDTO;
import giuseppetavella.D5.services.DipendentiService;
import giuseppetavella.D5.services.PrenotazioniService;
import giuseppetavella.D5.services.ViaggiService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired
    private PrenotazioniService prenotazioniService;


    // @GetMapping
    // public List<ViaggioDaMandareDTO> findAll() {
    //     return this.viaggiService.findAll();
    // }

    // @GetMapping("/{dipendenteId}")
    // public DipendenteDaMandareDTO findById(@PathVariable UUID dipendenteId) {
    //     Dipendente dipendente = this.dipendentiService.findById(dipendenteId);
    //     return new DipendenteDaMandareDTO(dipendente);
    // }


    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public PrenotazioneDaMandareDTO addNewPrenotazione(@RequestBody @Validated NuovaPrenotazioneMandataDTO body,
    //                                                 BindingResult validationResult)
    // {
    //
    //     // check if validation errors
    //     if (validationResult.hasErrors()) {
    //         // here we get the errors 
    //         List<String> errors = validationResult
    //                 .getFieldErrors()
    //                 .stream()
    //                 .map(fieldError -> fieldError.getDefaultMessage())
    //                 .toList();
    //         // we throw the exception that is specific to payload validation
    //         // this exception will then be handled by the appropriate
    //         // exception handler at the framework level
    //         throw new ValidazionePayloadException(errors);
    //
    //     }
    //
    //     return this.prenotazioniService.aggiungiNuovaPrenotazione(body);
    // }


    // @PostMapping("/{dipendenteId}/avatarImage")
    // @ResponseStatus(HttpStatus.CREATED)
    // public DipendenteDaMandareDTO uploadAuthorAvatarImage(
    //         @RequestParam("profile_picture") MultipartFile file,
    //         @PathVariable UUID dipendenteId)
    // {
    //
    //     return this.dipendentiService.uploadAvatarImage(dipendenteId, file);
    // }


    // @PutMapping("/{authorId}")
    // public Author update(@PathVariable String authorId, @RequestBody NewAuthorPayload body) {
    //     return authorsService.update(authorId, body);
    // }
    //
    //
    // @DeleteMapping("/{authorId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete(@PathVariable String authorId) {
    //     authorsService.delete(authorId);
    // }

}
