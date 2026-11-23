package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Optional<Vehicule> retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules (List<Vehicule> vehicules);

    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);


    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findDisponibles();
    List<Vehicule> findByMarqueContaining(String marque);
    List<Vehicule> findByTarifSuperieurA(BigDecimal tarif);
    List<Vehicule> findByMarqueDisponibles(String marque);
}