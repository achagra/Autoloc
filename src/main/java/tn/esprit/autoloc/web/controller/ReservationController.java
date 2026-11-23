package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Reservation")
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return reservationService.addReservation(r);
    }

    @GetMapping("/getReservations")
    public List<Reservation> getAllReservations(){
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/getReservations/{idr}")
    public Optional<Reservation> getReservationById(@PathVariable long idr){
        return reservationService.retrieveReservation(idr);
    }

    @DeleteMapping("/deleteReservation/{idr}")
    public void deleteReservation(@PathVariable long idr){
        reservationService.removeReservation(idr);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r){
        return reservationService.updateReservation(r);
    }

    @GetMapping("/debut-apres")                           // Q14
    public List<Reservation> getByDateDebutApres(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return reservationService.findByDateDebutAfter(date);
    }

    @GetMapping("/client/{idClient}")
    public List<Reservation> getReservationsByClient(@PathVariable Long idClient) {
        return reservationService.getReservationsByClient(idClient);
    }

    @GetMapping("/count-par-client")
    public List<Object[]> countReservationsByClient() {
        return reservationService.countReservationsByClient();
    }
}