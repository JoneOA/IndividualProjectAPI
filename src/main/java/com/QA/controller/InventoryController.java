package com.QA.controller;

import com.QA.model.Inventory;
import com.QA.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public List<Inventory> listAllPokemon() {
        return inventoryRepository.findAll();
    }

    @RequestMapping(value = "inventory", method = RequestMethod.POST)
    public Inventory addPokemon(@RequestBody Inventory pokemon){
        return inventoryRepository.saveAndFlush(pokemon);
    }

    @RequestMapping(value = "inventory/{id}", method = RequestMethod.GET)
    public Inventory getPokemonById(@PathVariable Long id){
        return inventoryRepository.findOne(id);
    }

    @Transactional
    @RequestMapping(value = "inventory/{id}", method = RequestMethod.PUT)
    public Inventory updatePokemon(@PathVariable Long id, @RequestBody Inventory pokemon) {
            Inventory existing = inventoryRepository.findOne(id);
            existing.setName(pokemon.getName());
            existing.setType(pokemon.getType());
            existing.setHP(pokemon.getHP());
            existing.setAttack(pokemon.getAttack());
            existing.setDefence(pokemon.getDefence());
            existing.setSpAttack(pokemon.getSpAttack());
            existing.setSpDefence(pokemon.getSpDefence());
            existing.setSpeed(pokemon.getSpeed());
            inventoryRepository.saveAndFlush(existing);
            return existing;
    }

    @RequestMapping(value = "inventory/name/{name}", method = RequestMethod.GET)
    public Inventory getPokemonByName(@PathVariable String name){
        return inventoryRepository.findByName(name);
    }

    @RequestMapping(value = "inventory/{id}", method = RequestMethod.DELETE)
    public Inventory deletePokemon(@PathVariable Long id) {
        Inventory existing = inventoryRepository.findOne(id);
        inventoryRepository.delete(existing);
        return existing;
    }
}
