package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    final ReservationRepository reRepo ;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reRepo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reRepo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reRepo.save(r);
    }

    @Override
    public Optional<Reservation> retrieveReservation(Long idReservation) {
        return Optional.ofNullable(reRepo.findById(idReservation).orElse(null));
    }

    @Override
    public void removeReservation(Long idReservation) {
        reRepo.deleteById(idReservation);

    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return (List<Reservation>) reRepo.saveAll(reservations);
    }

    @Override
    public List<Reservation> findByDateDebutAfter(LocalDate date) {
        return null;
    }

    @Override
    public List<Reservation> getReservationsByClient(Long idClient) {
        return reRepo.getReservationsByClient(idClient);
    }

    @Override
    public List<Object[]> countReservationsByClient() {
        return reRepo.countReservationsByClient();
    }
}
