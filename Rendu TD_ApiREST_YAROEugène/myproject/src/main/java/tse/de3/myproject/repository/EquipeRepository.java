package tse.de3.myproject.repository;

import tse.de3.myproject.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}