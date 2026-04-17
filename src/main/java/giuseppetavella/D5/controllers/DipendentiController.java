package giuseppetavella.D5.controllers;


import giuseppetavella.D5.entities.Dipendente;
import giuseppetavella.D5.exceptions.ValidazionePayloadException;
import giuseppetavella.D5.payloads.in_request.NuovoDipendenteMandatoDTO;
import giuseppetavella.D5.payloads.in_response.DipendenteDaMandareDTO;
import giuseppetavella.D5.services.DipendentiService;
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
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    private DipendentiService dipendentiService;


    @GetMapping
    public List<DipendenteDaMandareDTO> findAll() {
        return this.dipendentiService.findAll();
    }

    @GetMapping("/{dipendenteId}")
    public DipendenteDaMandareDTO findById(@PathVariable UUID dipendenteId) {
        Dipendente dipendente = this.dipendentiService.findById(dipendenteId);
        return new DipendenteDaMandareDTO(dipendente);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDaMandareDTO addNewAuthor(@RequestBody @Validated NuovoDipendenteMandatoDTO body,
                                        BindingResult validationResult)
    {

        // check if validation errors
        if (validationResult.hasErrors()) {
            // here we get the errors 
            List<String> errors = validationResult
                    .getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            // we throw the exception that is specific to payload validation
            // this exception will then be handled by the appropriate
            // exception handler at the framework level
            throw new ValidazionePayloadException(errors);

        }

        return this.dipendentiService.aggiungiNuovoDipendente(body);
    }
    

    @PostMapping("/{dipendenteId}/avatarImage")
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDaMandareDTO uploadAuthorAvatarImage(
            @RequestParam("profile_picture") MultipartFile file,
            @PathVariable UUID dipendenteId)
    {

        return this.dipendentiService.uploadAvatarImage(dipendenteId, file);
    }



}
