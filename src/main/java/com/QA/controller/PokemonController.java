package com.QA.controller;


import com.QA.repository.PokemonRepositoryId;
import com.QA.model.Pokemon;
import com.QA.repository.PokemonRepositoryName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    private PokemonRepositoryId pokemonRepositoryId;
    private PokemonRepositoryName pokemonRepositoryName;

    @RequestMapping(value = "pokemon", method = RequestMethod.GET)
    public List<Pokemon> listAllPokemon() {
        return pokemonRepositoryId.findAll();
    }

    @RequestMapping(value = "pokemon", method = RequestMethod.POST)
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        return pokemonRepositoryId.saveAndFlush(pokemon);
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable Long id){
        return pokemonRepositoryId.findOne(id);
    }

    @RequestMapping(value = "pokemon/{name}", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable String name){
        return pokemonRepositoryName.findOne(name);
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.DELETE)
    public Pokemon deletePokemon(@PathVariable Long id) {
        Pokemon existing = pokemonRepositoryId.findOne(id);
        pokemonRepositoryId.delete(existing);
        return existing;
    }
}
