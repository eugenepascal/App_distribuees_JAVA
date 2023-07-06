package org.rygn.first_graphql.resolver;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.rygn.first_graphql.model.Player;
import org.rygn.first_graphql.repository.PlayerRepository;
import java.util.List;

@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(String name, String position, Long teamId) {
        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        // Set the team using the teamId or fetch it from the repository
        // player.setTeam(team);
        return playerRepository.save(player);
    }

    public boolean deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return true;
    }
}
