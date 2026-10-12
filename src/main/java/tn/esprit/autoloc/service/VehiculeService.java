package tn.esprit.autoloc.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService  {
    final VehiculeRepository veRepo ;
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
}
