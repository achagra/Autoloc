package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    Optional<Reservation> retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List<Reservation> addReservations (List<Reservation> reservations);


    List<Reservation> findByDateDebutAfter(LocalDate date);

    List<Reservation> getReservationsByClient(Long idClient);
    List<Object[]> countReservationsByClient();
}