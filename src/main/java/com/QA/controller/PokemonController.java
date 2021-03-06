package com.QA.controller;


import com.QA.repository.PokemonRepository;
import com.QA.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @RequestMapping(value = "pokemon", method = RequestMethod.GET)
    public List<Pokemon> listAllPokemon() {
        return pokemonRepository.findAll();
    }

    @RequestMapping(value = "pokemon", method = RequestMethod.POST)
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        return pokemonRepository.saveAndFlush(pokemon);
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
    public Pokemon getPokemonById(@PathVariable Long id){
        return pokemonRepository.findOne(id);
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.DELETE)
    public Pokemon deletePokemon(@PathVariable Long id) {
        Pokemon existing = pokemonRepository.findOne(id);
        pokemonRepository.delete(existing);
        return existing;
    }

    @RequestMapping(value = "pokemon/name/{name}", method = RequestMethod.GET)
    public Pokemon getPokemonByName(@PathVariable String name){
        return pokemonRepository.findByName(name);
    }
}
