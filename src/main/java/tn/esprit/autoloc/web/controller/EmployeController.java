package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Employe")
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/addEmploye")
    public EmployeDTO addEmploye(@RequestBody Employe e){
        return employeService.addEmploye(e);
    }

    @GetMapping("/getEmployes")
    public List<EmployeDTO> getAllEmployes(){
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/getEmployes/{ide}")
    public EmployeDTO getEmployeById(@PathVariable long ide){
        return employeService.retrieveEmploye(ide);
    }

    @DeleteMapping("/deleteEmploye/{ide}")
    public void deleteEmploye(@PathVariable long ide){
        employeService.removeEmploye(ide);
    }

    @PutMapping("/updateEmploye")
    public EmployeDTO updateEmploye(@RequestBody Employe e){
        return employeService.updateEmploye(e);
    }

    @PutMapping("/affecterEmploye/{ide}/{ida}")
    public EmployeDTO affecterEmploye(@PathVariable long ide, @PathVariable long ida){
        return employeService.affecterEmploye(ide, ida);
    }

    @PutMapping("/desaffecterEmploye/{ide}")
    public EmployeDTO desaffecterEmploye(@PathVariable long ide){
        return employeService.desaffecterEmploye(ide);
    }
}