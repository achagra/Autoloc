package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Employe")
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/addEmploye")
    public Employe addEmploye(@RequestBody Employe e){
        return employeService.addEmploye(e);
    }

    @GetMapping("/getEmployes")
    public List<Employe> getAllEmployes(){
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/getEmployes/{ide}")
    public Optional<Employe> getEmployeById(@PathVariable long ide){
        return employeService.retrieveEmploye(ide);
    }

    @DeleteMapping("/deleteEmploye/{ide}")
    public void deleteEmploye(@PathVariable long ide){
        employeService.removeEmploye(ide);
    }

    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@RequestBody Employe e){
        return employeService.updateEmploye(e);
    }
}