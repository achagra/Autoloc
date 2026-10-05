package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Paiement;

import java.util.List;
import java.util.Optional;

public interface IPaiementService {
    List<Paiement> retrieveAllPaiements();
    Paiement addPaiement(Paiement p);
    Paiement updatePaiement(Paiement p);
    Optional<Paiement> retrievePaiement(Long idPaiement);
    void removePaiement(Long idPaiement);
    List<Paiement> addPaiements (List<Paiement> paiement);
}
