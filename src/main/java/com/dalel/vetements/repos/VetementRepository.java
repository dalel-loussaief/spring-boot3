package com.dalel.vetements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dalel.vetements.entities.Genres;
import com.dalel.vetements.entities.Vetement;

@RepositoryRestResource(path = "rest")
public interface VetementRepository extends JpaRepository<Vetement, Long> {
	List<Vetement> findBynomvetement(String nomvetement);
	List<Vetement> findBynomvetementContains(String nomvetement); 
	
	/*@Query("select v from Vetement v where v.nomvetement like %?1 and v.prixvetement > ?2")
	List<Vetement> findByNomPrix (String nom, Double prix);*/

	@Query("select v from Vetement v where v.nomvetement like %:nom and v.prixvetement > :prix")
	List<Vetement> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select v from Vetement v where v.genres = ?1")
	List<Vetement> findByGenres(Genres genres);
	
	List<Vetement> findByGenresIdG(Long id);
	
	List<Vetement> findByOrderByNomvetementAsc();
	
	@Query("select v from Vetement v order by v.nomvetement ASC, v.prixvetement DESC")
	List<Vetement> trierVetementNomsPrix ();
	
	
}
