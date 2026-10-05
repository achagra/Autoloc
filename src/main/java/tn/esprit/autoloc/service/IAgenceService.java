package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    List<Agence> retrieveAllAgences();



    Agence addAgence(Agence a);
    Agence updateAgence(Agence a);
    Optional<Agence> retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);


    List<Agence> addAgences(List<Agence> agences);
}
