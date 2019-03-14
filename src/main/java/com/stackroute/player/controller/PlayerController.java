package com.stackroute.player.controller;

import com.stackroute.player.domain.Player;
import com.stackroute.player.exceptions.PlayerAlreadyExistException;
import com.stackroute.player.exceptions.PlayerNotFoundException;
import com.stackroute.player.service.PlayerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@Api(value = "PlayerControllerAPI" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerServiceImpl = playerServiceImpl;
    }

    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) throws PlayerAlreadyExistException {
        Player savedPlayer = null;
//        try {
            savedPlayer = playerServiceImpl.savePlayer(player);
//        }
//        catch (PlayerAlreadyExistException e){
//            return new ResponseEntity<Player>(savedPlayer, HttpStatus.ALREADY_REPORTED);
//        }
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);

    }

    //    @ApiOperation("Gets the information of all players")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Player.class)})
    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayer() throws PlayerNotFoundException {
        ResponseEntity responseEntity;
//        try {
        List<Player> playerList = playerServiceImpl.getPlayers();
        responseEntity = new ResponseEntity<List<Player>>(playerList, HttpStatus.OK);
//        } catch (PlayerNotFoundException e) {
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }

    @DeleteMapping("player/{id}")

    public ResponseEntity<List<Player>> deletePlayerById(@PathVariable int id) throws PlayerNotFoundException {
        playerServiceImpl.deletePlayerById(id);
        ResponseEntity responseEntity;
//        try {
        responseEntity = new ResponseEntity<List<Player>>(playerServiceImpl.getPlayers() , HttpStatus.OK);
//        } catch (PlayerNotFoundException e) {
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//
////            e.printStackTrace();
//        }
        return responseEntity;
    }

    @PutMapping("player/{id}")

    public ResponseEntity<List<Player>> updatedPlayer(@PathVariable int id , @RequestBody Player player) throws PlayerNotFoundException {

        ResponseEntity responseEntity;
//        try {
        playerServiceImpl.updatedPlayerScores(player,id);
//        } catch (PlayerNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
        responseEntity = new ResponseEntity<List<Player>>(playerServiceImpl.getPlayers() , HttpStatus.OK);
//        } catch (PlayerNotFoundException e) {
//            responseEntity = new ResponseEntity<String >(e.getMessage(), HttpStatus.CONFLICT);
//            e.printStackTrace();
//        }
        return responseEntity;
    }

//    @GetMapping("player/{name}")
//
//    public ResponseEntity<List<Player>> searchByPlayerName(@PathVariable String name){
//        List<Player> player = playerServiceImpl.searchByPlayerName(name);
//        return new ResponseEntity<List<Player>>(player , HttpStatus.OK);
//    }

}
