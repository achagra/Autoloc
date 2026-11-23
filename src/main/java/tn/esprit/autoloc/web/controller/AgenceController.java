package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Agence")
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/addAgence")
    public Agence addAgence(@RequestBody Agence a){
        return agenceService.addAgence(a);
    }

    @GetMapping("/getAgences")
    public List<Agence> getAllAgences(){
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/getAgences/{ida}")
    public Optional<Agence> getAgenceById(@PathVariable long ida){
        return agenceService.retrieveAgence(ida);
    }

    @DeleteMapping("/deleteAgence/{ida}")
    public void deleteAgence(@PathVariable long ida){
        agenceService.removeAgence(ida);
    }

    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence a){
        return agenceService.updateAgence(a);
    }

    @GetMapping("/ville/{ville}")                         // Q4
    public List<Agence> getByVille(@PathVariable String ville) {
        return agenceService.findByVille(ville);
    }
}