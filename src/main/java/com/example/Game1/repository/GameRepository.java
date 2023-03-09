package com.example.Game1.repository;

import com.example.Game1.model.Game;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM _game a WHERE a.name LIKE %?1%", nativeQuery = true)
    public List<Game> search(String keyword);

}
