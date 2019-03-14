package com.stackroute.player.service;

import com.stackroute.player.domain.Player;

import java.util.List;

public interface PlayerService {

    public Player savePlayer(Player player) throws Exception;

    public List<Player> getPlayers() throws Exception;

    public void deletePlayerById(int id) throws Exception;

    public Player updatedPlayerScores(Player player, int id) throws Exception;

//    public List<Player> searchByPlayerName(String name);
}


