package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EquipementService implements IEquipementService {
    final EquipementRepository eqRepo ;
    @Override
    public List<Equipement> retrieveAllEquipements() {
        return (List<Equipement>) eqRepo.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement e) {
        return eqRepo.save(e);
    }

    @Override
    public Equipement updateEquipement(Equipement e) {
        return eqRepo.save(e);
    }

    @Override
    public Optional<Equipement> retrieveEquipement(Long idEquipement) {
        return Optional.ofNullable(eqRepo.findById(idEquipement).orElse(null));
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        eqRepo.deleteById(idEquipement);

    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> Equipements) {
        return (List<Equipement>) eqRepo.saveAll(Equipements);
    }
}
