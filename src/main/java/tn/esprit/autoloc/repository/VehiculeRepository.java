package tn.esprit.autoloc.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

    // Q1 : findBy + Marque
    List<Vehicule> findByMarque(String marque);

    // Q2 : findBy + Categorie (enum)
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Q3 : findBy + Statut (enum), on passera DISPONIBLE depuis le Service
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Q5 : Containing = LIKE %x%
    List<Vehicule> findByMarqueContainingIgnoreCase(String marque);

    // Q8 : GreaterThan sur tarifJournalier (BigDecimal)
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    // Q11 : And
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
}