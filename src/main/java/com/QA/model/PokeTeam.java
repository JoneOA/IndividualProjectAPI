package com.QA.model;

import javax.persistence.*;

@Entity
@Table(name="team")
public class PokeTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long pokeId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long teamId) {
        this.id = teamId;
    }

    public Long getPokeId() {
        return pokeId;
    }

    public void setPokeId(Long id) {
        this.pokeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateAll(PokeTeam pokemon) {
        this.pokeId = pokemon.pokeId;
        this.name = pokemon.name;
    }
}