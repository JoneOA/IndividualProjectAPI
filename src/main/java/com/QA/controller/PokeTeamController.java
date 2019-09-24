package com.QA.controller;

import com.QA.model.PokeTeam;

import com.QA.repository.PokeTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class PokeTeamController {

    @Autowired
    private PokeTeamRepository repository;

    @RequestMapping(value = "team", method = RequestMethod.GET)
    public List<PokeTeam> listAllPokemon() {
        return repository.findAll();
    }

    @RequestMapping(value = "team", method = RequestMethod.POST)
    public PokeTeam addPokemon(@RequestBody PokeTeam pokemon){
        return repository.saveAndFlush(pokemon);
    }

    @RequestMapping(value = "team/{id}", method = RequestMethod.GET)
    public PokeTeam getPokemonById(@PathVariable Long id){
        return repository.findOne(id);
    }

    @Transactional
    @RequestMapping(value = "team/{id}", method = RequestMethod.PUT)
    public PokeTeam updatePokemon(@PathVariable Long id, @RequestBody PokeTeam pokemon) {
        PokeTeam existing = repository.findOne(id);
        existing.setId(pokemon.getId());
        existing.setName(pokemon.getName());
        System.out.println(existing.getId());
        System.out.println(existing.getName());
        return repository.saveAndFlush(existing);
    }

    @RequestMapping(value = "team/name/{name}", method = RequestMethod.GET)
    public PokeTeam getPokemonByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @RequestMapping(value = "team/{id}", method = RequestMethod.DELETE)
    public PokeTeam deletePokemon(@PathVariable Long id) {
        PokeTeam existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
