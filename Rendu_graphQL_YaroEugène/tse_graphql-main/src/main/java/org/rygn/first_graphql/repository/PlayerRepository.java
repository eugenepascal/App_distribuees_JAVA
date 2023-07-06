package org.rygn.first_graphql.repository;

import org.rygn.first_graphql.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}