package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Vehicule")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule v){
        return vehiculeService.addVehicule(v);
    }

    @GetMapping("/getVehicules")
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/getVehicules/{idv}")
    public Optional<Vehicule> getVehiculeById(@PathVariable long idv){
        return vehiculeService.retrieveVehicule(idv);
    }

    @DeleteMapping("/deleteVehicule/{idv}")
    public void deleteVehicule(@PathVariable long idv){
        vehiculeService.removeVehicule(idv);
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule v){
        return vehiculeService.updateVehicule(v);
    }
}