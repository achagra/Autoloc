package tn.esprit.autoloc.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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
    // Véhicules d'une agence
    @Query("SELECT v FROM Vehicule v WHERE v.agence.idAgence = :idAgence")
    List<Vehicule> getVehiculesByAgence(@Param("idAgence") Long idAgence);

    // Nombre de véhicules par agence
    @Query("SELECT a.idAgence, a.nom, COUNT(v) " +
            "FROM Vehicule v JOIN v.agence a " +
            "GROUP BY a.idAgence, a.nom")
    List<Object[]> countVehiculesByAgence();
}