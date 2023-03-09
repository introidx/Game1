package com.example.Game1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_game")
public class Game {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String url;
    private String author;
    private LocalDate publishedDate = LocalDate.now();
}
