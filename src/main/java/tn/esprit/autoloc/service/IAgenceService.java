package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;

import java.util.List;

public interface IAgenceService {
    List<AgenceDTO> retrieveAllAgences();

    AgenceDTO addAgence(Agence a);
    AgenceDTO updateAgence(Agence a);
    AgenceDTO retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);

    List<AgenceDTO> addAgences(List<Agence> agences);

    List<AgenceDTO> findByVille(String ville);
}