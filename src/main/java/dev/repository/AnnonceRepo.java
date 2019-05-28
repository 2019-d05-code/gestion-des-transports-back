package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.domain.Annonce;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
	
	@Query("select annonces from annnonce where annonce.annonceur.email=email")
	Optional<List<Annonce>> trouveAnnoncesParEmailAnnonceur(String email);

}
