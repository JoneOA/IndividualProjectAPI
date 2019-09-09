package com.QA.controller;


import com.QA.repository.PokemonRepository;
import com.QA.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Pokemon addNote (@RequestBody Pokemon pokemon){
        return pokemonRepository.saveAndFlush(pokemon);
    }

    @RequestMapping(value = "pokemon/id", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable Long id){
        return pokemonRepository.findOne(id);
    }
}
