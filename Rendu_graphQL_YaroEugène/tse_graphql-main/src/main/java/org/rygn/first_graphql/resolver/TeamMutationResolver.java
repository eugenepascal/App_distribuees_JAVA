package org.rygn.first_graphql.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.rygn.first_graphql.model.Team;
import org.rygn.first_graphql.repository.TeamRepository;

@Component
public class TeamMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(String name) {
        Team team = new Team();
        team.setName(name);
        return teamRepository.save(team);
    }

    public boolean deleteTeam(Long id) {
        teamRepository.deleteById(id);
        return true;
    }
}
