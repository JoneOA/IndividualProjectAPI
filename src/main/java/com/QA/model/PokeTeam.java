package com.QA.model;

import javax.persistence.*;

@Entity
@Table(name="team")
public class PokeTeam {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateAll(PokeTeam pokemon) {
        this.id = pokemon.id;
        this.name = pokemon.name;
    }
}