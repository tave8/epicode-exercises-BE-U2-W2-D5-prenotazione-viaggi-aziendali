package giuseppetavella.D5.repositories;

import giuseppetavella.D5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    // @Query(nativeQuery = true, value = """
    //     WITH Q_postazione AS (
    //         SELECT (COUNT(*) = 0) AS postazione_e_libera
    //         FROM prenotazioni
    //         WHERE postazione_id = :postazioneId
    //         AND prenotato_per_data = :dataPerCuiPrenotare
    //     ),
    //     Q_utente AS (
    //         SELECT (COUNT(*) = 0) AS utente_e_libero
    //         FROM prenotazioni
    //         WHERE utente_id = :utenteId
    //         AND prenotato_per_data = :dataPerCuiPrenotare
    //     ),
    //     Q_disponibilita AS (
    //         SELECT * FROM Q_postazione CROSS JOIN Q_utente
    //     )
    //     SELECT (postazione_e_libera AND utente_e_libero) AS puo_prenotare
    //     FROM Q_disponibilita
    // """)
    // Boolean puoPrenotare(
    //         @Param("postazioneId") UUID postazioneId,
    //         @Param("utenteId") UUID utenteId,
    //         @Param("dataPerCuiPrenotare") LocalDate dataPerCuiPrenotare
    // );

}
