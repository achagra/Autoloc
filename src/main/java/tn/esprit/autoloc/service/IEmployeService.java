package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    List<Employe> retrieveAllEmployes();
    Employe addEmploye(Employe c);
    Employe updateClient(Client c);
    Optional<Employe> retrieveEmploye ( Long idEmploye);
    void removeEmploye(Long idEmploye);
    List<Employe> addEmployes (List<Employe> Employes);
}
