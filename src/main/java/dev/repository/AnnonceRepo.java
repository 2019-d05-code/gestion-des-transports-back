package dev.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.domain.Annonce;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
	
	@Query("select a from Annonce a where a.annonceur.email = :email")
	Optional<List<Annonce>> findByAnnonceurEmail(@Param("email") String email);
	
	@Query("select a from Annonce a where a.dateTimeDepart > :dateTimeDuJour")
	Optional<List<Annonce>> findAllCurrent(@Param("dateTimeDuJour") LocalDateTime dateTimeDuJour);


}
