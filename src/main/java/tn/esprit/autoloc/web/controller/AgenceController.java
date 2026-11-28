package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Agence")
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/addAgence")
    public AgenceDTO addAgence(@RequestBody Agence a){
        return agenceService.addAgence(a);
    }

    @GetMapping("/getAgences")
    public List<AgenceDTO> getAllAgences(){
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/getAgences/{ida}")
    public AgenceDTO getAgenceById(@PathVariable long ida){
        return agenceService.retrieveAgence(ida);
    }

    @DeleteMapping("/deleteAgence/{ida}")
    public void deleteAgence(@PathVariable long ida){
        agenceService.removeAgence(ida);
    }

    @PutMapping("/updateAgence")
    public AgenceDTO updateAgence(@RequestBody Agence a){
        return agenceService.updateAgence(a);
    }

    @GetMapping("/ville/{ville}")                         // Q4
    public List<AgenceDTO> getByVille(@PathVariable String ville) {
        return agenceService.findByVille(ville);
    }
}