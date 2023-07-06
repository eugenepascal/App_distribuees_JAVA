package org.rygn.first_graphql.service;


import org.rygn.first_graphql.model.Team;
import org.rygn.first_graphql.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
}
