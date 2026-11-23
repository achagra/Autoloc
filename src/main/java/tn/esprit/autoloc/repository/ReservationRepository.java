package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    // Q14 : After = strictement postérieur
    List<Reservation> findByDateDebutAfter(LocalDate date);

    // Réservations d'un client
    @Query("SELECT r FROM Reservation r WHERE r.client.idClient = :idClient")
    List<Reservation> getReservationsByClient(@Param("idClient") Long idClient);

    // Nombre de réservations par client
    @Query("SELECT c.idClient, c.nom, c.prenom, COUNT(r) " +
            "FROM Reservation r JOIN r.client c " +
            "GROUP BY c.idClient, c.nom, c.prenom")
    List<Object[]> countReservationsByClient();
}