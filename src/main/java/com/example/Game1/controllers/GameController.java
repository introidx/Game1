package com.example.Game1.controllers;

import com.example.Game1.model.Game;
import com.example.Game1.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createSingleGame(@RequestBody Game newGame) {
        Game game = gameService.createSingleGame(newGame);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> readSingleGame(@PathVariable int id) {
        Game game = gameService.readSingleGame(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> list = gameService.getAllGames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Game>> getFromSearch(@PathVariable String keyword) {
        List<Game> games = gameService.getGameFromSearch(keyword);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateSingleGame(@PathVariable int id, @RequestBody Game newGame) {
        Game game = gameService.updateSingleGame(id, newGame);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSingleGame(@PathVariable int id) {
        gameService.deleteSingleGame(id);
        return new ResponseEntity<>("Game Deleted Successfully", HttpStatus.OK);
    }
}
