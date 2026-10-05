package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Contrat;

import java.util.List;
import java.util.Optional;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat C);
    Contrat updateContrat(Contrat C);
    Optional<Contrat> retrieveContrat(Long idContrat);
    void removeContrat(Long idContrat);

    List<Contrat> addContrats(List<Contrat> contrats);
}
