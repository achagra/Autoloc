package tn.esprit.autoloc.service;



import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeService implements IEmployeService {
    EmployeRepository eRepo;

    @Override
    public List<Employe> retrieveAllEmployes() {

        return (List<Employe>) eRepo.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {

        return eRepo.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {

        return eRepo.save(e);
    }

    @Override
    public Optional<Employe> retrieveEmploye(Long idEmploye) {
        return Optional.ofNullable(eRepo.findById(idEmploye).orElse(null));
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        eRepo.deleteById(idEmploye);

    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        return (List<Employe>) eRepo.saveAll(employes);
    }
}
