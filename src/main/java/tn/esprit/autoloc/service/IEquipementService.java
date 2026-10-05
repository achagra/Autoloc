package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Equipement;

import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    List<Equipement> retrieveAllEquipements();
    Equipement addEquipement(Equipement e);
    Equipement updateEquipement(Equipement e);
    Optional<Equipement > retrieveEquipement (Long idEquipement );
    void removeEquipement (Long idEquipement );
    List<Equipement> addEquipements (List<Equipement > Equipements);
}
