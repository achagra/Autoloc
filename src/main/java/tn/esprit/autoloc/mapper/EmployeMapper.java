package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeMapper {

    @Mapping(source = "agence.nom", target = "nomAgence")
    EmployeDTO toDto(Employe employe);

    List<EmployeDTO> toDtoList(Iterable<Employe> employes);
}
