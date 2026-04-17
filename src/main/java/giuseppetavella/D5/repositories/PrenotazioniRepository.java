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

    @Query(nativeQuery = true, value = """
       SELECT 
    	(COUNT(*) = 0)
    		AS puo_prenotare
        FROM
            prenotazioni
        WHERE 
            dipendente_id = :dipendenteId
            AND data_prenotato_per = :dataPerCuiPrenotare

    """)
    boolean puoPrenotare(
            @Param("dipendenteId") UUID dipendenteId,
            @Param("dataPerCuiPrenotare") LocalDate dataPerCuiPrenotare
    );

}
