package com.stackroute.player.service;

import com.stackroute.player.domain.Player;
import com.stackroute.player.exceptions.PlayerAlreadyExistException;
import com.stackroute.player.exceptions.PlayerNotFoundException;
import com.stackroute.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService,ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }


    public Player savePlayer(Player player) throws PlayerAlreadyExistException {
        Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }

    public List<Player> getPlayers() throws PlayerNotFoundException {

        List<Player> allPlayers = (List) playerRepository.findAll();

        if(allPlayers.isEmpty()){
            throw new PlayerNotFoundException("Players not found");
        }
        else {
            return allPlayers;
        }


    }

    public Player updatedPlayerScores(Player player, int id) throws PlayerNotFoundException{
        Player playerById = playerRepository.findById(id).get();
        if(playerById == null){
            throw new PlayerNotFoundException("Players not found");
        }
        else {
            playerById.setScore(player.getScore());
            return playerRepository.save(playerById);
        }
    }

    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

//    public List<Player> searchByPlayerName(String playerName) {
//        List<Player> player = playerRepository.searchByPlayerName(playerName);
//        return player;
//
//    }


    @Value("${player.1.name:default}")
    String name1;
    @Value("${player.1.score:default}")
    int  score1;

    @Value("${player.2.name:default}")
    String name2;
    @Value("${player.2.score:default}")
    int  score2;


    @Override

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        playerRepository.save(new Player("1",name1, score1));

    }

    @Override

    public void run(String... args) throws Exception {

        playerRepository.save(new Player("2", name2, score2));

    }

}
