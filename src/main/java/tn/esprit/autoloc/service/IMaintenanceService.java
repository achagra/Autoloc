package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;
import java.util.Optional;

public interface IMaintenanceService {
    List<Maintenance> retrieveAllMaintenances();
    Maintenance addMaintenance(Maintenance m);
    Maintenance updateMaintenance(Maintenance m);
    Optional<Maintenance> retrieveMaintenance(Long idCMaintenance);
    void removeMaintenance(Long idMaintenance);
    List<Maintenance> addMaintenances (List<Maintenance> maintenances);
}
