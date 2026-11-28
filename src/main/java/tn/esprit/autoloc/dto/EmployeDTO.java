package tn.esprit.autoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.RoleEmploye;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
    private Long idEmploye;      // gardé pour pouvoir appeler affecter/desaffecter/delete
    private String nom;
    private String prenom;
    private RoleEmploye role;
    private String nomAgence;    // vient de l'entité Agence
}
