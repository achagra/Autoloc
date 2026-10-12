package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Maintenance")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance m){
        return maintenanceService.addMaintenance(m);
    }

    @GetMapping("/getMaintenances")
    public List<Maintenance> getAllMaintenances(){
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping("/getMaintenances/{idm}")
    public Optional<Maintenance> getMaintenanceById(@PathVariable long idm){
        return maintenanceService.retrieveMaintenance(idm);
    }

    @DeleteMapping("/deleteMaintenance/{idm}")
    public void deleteMaintenance(@PathVariable long idm){
        maintenanceService.removeMaintenance(idm);
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance m){
        return maintenanceService.updateMaintenance(m);
    }
}