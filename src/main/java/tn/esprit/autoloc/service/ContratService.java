package tn.esprit.autoloc.service;



import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;
import java.util.Optional;

public class ContratService implements IContratService {
    ContratRepository coRepo ;
    @Override
    public List<Contrat> retrieveAllContrats() {

        return (List<Contrat>) coRepo.findAll();
    }

    @Override
    public Contrat addContrat(Contrat C) {
        return coRepo.save(C);
    }

    @Override
    public Contrat updateContrat(Contrat C) {

        return coRepo.save(C);
    }

    @Override
    public Optional<Contrat> retrieveContrat(Long idContrat) {
        return Optional.ofNullable(coRepo.findById(idContrat).orElse(null));
    }

    @Override
    public void removeContrat(Long idContrat) {
        coRepo.deleteById(idContrat);

    }

    @Override
    public List<Contrat> addContrats(List<Contrat> contrats) {
        return (List<Contrat>) coRepo.saveAll(contrats);
    }
}
