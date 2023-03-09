package com.example.Game1.service;

import com.example.Game1.model.Game;
import com.example.Game1.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game createSingleGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game readSingleGame(int id) {
        return gameRepository.findById(id).orElseThrow(() ->
                new FileSystemNotFoundException("User Not Found"));
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> getGameFromSearch(String keyword) {
        if (keyword == null) return gameRepository.findAll();
        return gameRepository.search(keyword);
    }

    @Override
    public Game updateSingleGame(int id,Game game) {
        game.setId(id);
        game.setPublishedDate(game.getPublishedDate());
        return gameRepository.save(game);
    }

    @Override
    public void deleteSingleGame(int id) {
        gameRepository.findById(id).orElseThrow(() ->
                new FileSystemNotFoundException("User Not Found"));
        gameRepository.deleteById(id);
    }
}
