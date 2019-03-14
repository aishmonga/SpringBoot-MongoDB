package com.stackroute.player.repository;

import com.stackroute.player.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository< Player, Integer > {
//    @Query(value = "Select p from Player p where p.playerName= ?1" )
//    List<Player> searchByPlayerName (String playerName);


//@Repository
//public interface PlayerRepository extends CrudRepository <Player, Integer >{
//    @Query(value = "Select p from Player p where p.playerName= ?1" )
//    List<Player> searchByPlayerName (String playerName);

//    @Query(value = "Select * from Player p" )
//    List<Player> searchAll ();
}
