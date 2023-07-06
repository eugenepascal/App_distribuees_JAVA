package org.rygn.first_graphql.resolver;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.rygn.first_graphql.model.Player;
import org.rygn.first_graphql.repository.PlayerRepository;
import java.util.List;

@Component
public class PlayerQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> allPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Long id) {
        return playerRepository.findById(id).orElse(null);
    }
}