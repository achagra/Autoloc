package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Equipement")
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement e){
        return equipementService.addEquipement(e);
    }

    @GetMapping("/getEquipements")
    public List<Equipement> getAllEquipements(){
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/getEquipements/{ide}")
    public Optional<Equipement> getEquipementById(@PathVariable long ide){
        return equipementService.retrieveEquipement(ide);
    }

    @DeleteMapping("/deleteEquipement/{ide}")
    public void deleteEquipement(@PathVariable long ide){
        equipementService.removeEquipement(ide);
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement e){
        return equipementService.updateEquipement(e);
    }
}