package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {
    final EmployeRepository eRepo;
    final AgenceRepository agRepo;

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

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe e = eRepo.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        e.setAgence(null);
        return eRepo.save(e);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe e = eRepo.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        Agence a = agRepo.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        if (e.getAgence() != null) {
            throw new IllegalStateException(
                    "L'employé appartient déjà à une agence : désaffectez-le d'abord.");
        }
        e.setAgence(a);
        return eRepo.save(e);
    }
}