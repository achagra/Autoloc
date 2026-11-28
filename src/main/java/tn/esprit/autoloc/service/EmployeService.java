package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;
import tn.esprit.autoloc.mapper.EmployeMapper;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {

    private final EmployeRepository eRepo;
    private final AgenceRepository agRepo;
    private final EmployeMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeDTO> retrieveAllEmployes() {
        return mapper.toDtoList(eRepo.findAll());
    }

    @Override
    @Transactional
    public EmployeDTO addEmploye(Employe e) {
        return mapper.toDto(eRepo.save(e));
    }

    @Override
    @Transactional
    public EmployeDTO updateEmploye(Employe e) {
        return mapper.toDto(eRepo.save(e));
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeDTO retrieveEmploye(Long idEmploye) {
        Employe e = eRepo.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        return mapper.toDto(e);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        eRepo.deleteById(idEmploye);
    }

    @Override
    @Transactional
    public List<EmployeDTO> addEmployes(List<Employe> employes) {
        return mapper.toDtoList(eRepo.saveAll(employes));
    }

    @Override
    @Transactional
    public EmployeDTO desaffecterEmploye(Long idEmploye) {
        Employe e = eRepo.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        e.setAgence(null);
        return mapper.toDto(eRepo.save(e));
    }

    @Override
    @Transactional
    public EmployeDTO affecterEmploye(Long idEmploye, Long idAgence) {
        Employe e = eRepo.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        Agence a = agRepo.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        if (e.getAgence() != null) {
            throw new IllegalStateException(
                    "L'employé appartient déjà à une agence : désaffectez-le d'abord.");
        }
        e.setAgence(a);
        return mapper.toDto(eRepo.save(e));
    }
}