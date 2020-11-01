package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	
	@Query("SELECT count(*) FROM Entreprise")
    public int countent();
    /* @Query("Select"
    + "DISTINCT dep from Departement dep "
    + "join dep.entreprise ent "
    + "where ent=:entreprise")
public List<Entreprise> getAllDepartementsNamesByEntreprise(@Param("entreprise") Entreprise entreprise);*/

}
