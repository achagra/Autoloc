package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;
import tn.esprit.autoloc.mapper.AgenceMapper;
import tn.esprit.autoloc.repository.AgenceRepository;


import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AgenceService implements IAgenceService {

    private final AgenceRepository repo;
    private final AgenceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<AgenceDTO> retrieveAllAgences() {
        return mapper.toDtoList(repo.findAll());
    }

    @Override
    @Transactional
    public AgenceDTO addAgence(Agence a) {
        return mapper.toDto(repo.save(a));
    }

    @Override
    @Transactional
    public AgenceDTO updateAgence(Agence a) {
        return mapper.toDto(repo.save(a));
    }

    @Override
    @Transactional(readOnly = true)
    public AgenceDTO retrieveAgence(Long idAgence) {
        Agence a = repo.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        return mapper.toDto(a);
    }

    @Override
    public void removeAgence(Long idAgence) {
        repo.deleteById(idAgence);
    }

    @Override
    @Transactional
    public List<AgenceDTO> addAgences(List<Agence> agences) {
        return mapper.toDtoList(repo.saveAll(agences));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgenceDTO> findByVille(String ville) {
        return mapper.toDtoList(repo.findByVille(ville));
    }
}
