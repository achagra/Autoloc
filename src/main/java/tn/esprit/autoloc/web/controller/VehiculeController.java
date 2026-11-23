package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.math.BigDecimal;
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

    @GetMapping("/marque/{marque}")                       // Q1
    public List<Vehicule> getByMarque(@PathVariable String marque) {
        return vehiculeService.findByMarque(marque);
    }

    @GetMapping("/categorie/{categorie}")                 // Q2
    public List<Vehicule> getByCategorie(@PathVariable CategorieVehicule categorie) {
        return vehiculeService.findByCategorie(categorie);
    }

    @GetMapping("/disponibles")                           // Q3
    public List<Vehicule> getDisponibles() {
        return vehiculeService.findDisponibles();
    }

    @GetMapping("/search")                                // Q5
    public List<Vehicule> searchByMarque(@RequestParam String marque) {
        return vehiculeService.findByMarqueContaining(marque);
    }

    @GetMapping("/tarif-superieur")                       // Q8
    public List<Vehicule> getByTarifSuperieur(@RequestParam BigDecimal tarif) {
        return vehiculeService.findByTarifSuperieurA(tarif);
    }

    @GetMapping("/marque-disponibles")                    // Q11
    public List<Vehicule> getByMarqueDisponibles(@RequestParam String marque) {
        return vehiculeService.findByMarqueDisponibles(marque);
    }
}