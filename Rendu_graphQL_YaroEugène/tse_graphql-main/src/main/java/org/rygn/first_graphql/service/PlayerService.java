package org.rygn.first_graphql.service;


import org.rygn.first_graphql.model.Player;
import org.rygn.first_graphql.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }
}
