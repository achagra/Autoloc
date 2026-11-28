package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;

import java.util.List;

public interface IEmployeService {
    List<EmployeDTO> retrieveAllEmployes();
    EmployeDTO addEmploye(Employe e);
    EmployeDTO updateEmploye(Employe e);
    EmployeDTO retrieveEmploye(Long idEmploye);
    void removeEmploye(Long idEmploye);
    List<EmployeDTO> addEmployes(List<Employe> employes);

    EmployeDTO desaffecterEmploye(Long idEmploye);
    EmployeDTO affecterEmploye(Long idEmploye, Long idAgence);
}