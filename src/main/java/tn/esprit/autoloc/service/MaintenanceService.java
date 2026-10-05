package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;
import java.util.Optional;

public class MaintenanceService implements IMaintenanceService {
    MaintenanceRepository maRepo ;
    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return (List<Maintenance>) maRepo.findAll();
    }

    @Override
    public Maintenance addClient(Maintenance m) {
        return maRepo.save(m);
    }

    @Override
    public Maintenance updateClient(Maintenance m) {
        return maRepo.save(m);
    }

    @Override
    public Optional<Maintenance> retrieveMaintenance(Long idCMaintenance) {
        return Optional.ofNullable(maRepo.findById(idCMaintenance).orElse(null));
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maRepo.deleteById(idMaintenance);

    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) {
        return (List<Maintenance>) maRepo.saveAll(maintenances);
    }
}
