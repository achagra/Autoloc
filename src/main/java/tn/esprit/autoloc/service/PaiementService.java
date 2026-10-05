package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;
import java.util.Optional;

public class PaiementService implements IPaiementService {
    PaiementRepository paRepo ;
    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) paRepo.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement p) {
        return paRepo.save(p);
    }

    @Override
    public Paiement updatePaiement(Paiement p) {
        return paRepo.save(p);
    }

    @Override
    public Optional<Paiement> retrievePaiement(Long idPaiement) {
        return Optional.ofNullable(paRepo.findById(idPaiement).orElse(null));
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paRepo.deleteById(idPaiement);

    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiement) {
        return (List<Paiement>) paRepo.saveAll(paiement);
    }
}
