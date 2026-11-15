package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService {
    final VehiculeRepository veRepo;
    final AgenceRepository agRepo;
    final EquipementRepository eqRepo;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) veRepo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return veRepo.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return veRepo.save(v);
    }

    @Override
    public Optional<Vehicule> retrieveVehicule(Long idVehicule) {
        return Optional.ofNullable(veRepo.findById(idVehicule).orElse(null));
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        veRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return (List<Vehicule>) veRepo.saveAll(vehicules);
    }

    // Scénario 2 : véhicule neuf rattaché à une agence (ex : Sfax)
    @Override
    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule v = veRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Agence a = agRepo.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        v.setAgence(a);
        return veRepo.save(v);
    }

    // Scénario 3 : installer un équipement (ex : siège bébé)
    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = veRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement eq = eqRepo.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));
        v.getEquipements().add(eq);
        return veRepo.save(v);
    }

    // Scénario 3 : retirer l'équipement au retour
    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = veRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement eq = eqRepo.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));
        v.getEquipements().remove(eq);
        return veRepo.save(v);
    }
}