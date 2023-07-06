package org.rygn.first_graphql.repository;

import org.rygn.first_graphql.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {}