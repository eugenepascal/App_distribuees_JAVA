package tse.de3.myproject.repository;

import tse.de3.myproject.model.Joueur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

	Optional<Joueur> findByIdAndEquipeId(Long joueurId, Long equipeId);
}