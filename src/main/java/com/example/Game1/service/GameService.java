package com.example.Game1.service;

import com.example.Game1.model.Game;

import java.util.List;


public interface GameService {

    Game createSingleGame(Game game);
    Game readSingleGame(int id);
    List<Game> getAllGames();
    List<Game> getGameFromSearch(String keyword);
    Game updateSingleGame(int id,Game game);
    void deleteSingleGame(int id);


}

//i. Create Single Game
//ii. Read Single Game
//iii. Get All Games
//iv. Update Single Game
//v. Delete Single Game
