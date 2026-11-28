package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgenceMapper {
    AgenceDTO toDto(Agence agence);
    List<AgenceDTO> toDtoList(Iterable<Agence> agences);
}
