package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Paiement")
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement p){
        return paiementService.addPaiement(p);
    }

    @GetMapping("/getPaiements")
    public List<Paiement> getAllPaiements(){
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/getPaiements/{idp}")
    public Optional<Paiement> getPaiementById(@PathVariable long idp){
        return paiementService.retrievePaiement(idp);
    }

    @DeleteMapping("/deletePaiement/{idp}")
    public void deletePaiement(@PathVariable long idp){
        paiementService.removePaiement(idp);
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement p){
        return paiementService.updatePaiement(p);
    }
}