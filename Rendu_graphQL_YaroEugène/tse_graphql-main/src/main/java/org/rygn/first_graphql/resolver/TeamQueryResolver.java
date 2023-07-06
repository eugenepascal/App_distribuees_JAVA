package org.rygn.first_graphql.resolver;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.rygn.first_graphql.model.Team;
import org.rygn.first_graphql.repository.TeamRepository;
import java.util.List;

@Component
public class TeamQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> allTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
}
