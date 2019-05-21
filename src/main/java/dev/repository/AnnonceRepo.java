package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.domain.Annonce;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {

}
