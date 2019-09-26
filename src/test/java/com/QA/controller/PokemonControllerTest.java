package com.QA.controller;

import com.QA.model.Pokemon;
import com.QA.repository.PokemonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokemonControllerTest {

    @InjectMocks
    private PokemonController pokemonController;

    @Mock
    private PokemonRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addPokemonTest() {
        Pokemon pokemon = new Pokemon(1L, "Bulbasaur", "Grass", 1, 2, 3, 4, 5, 6);
        when(repository.saveAndFlush(pokemon)).thenReturn(pokemon);
        assertEquals(pokemonController.addPokemon(pokemon).getName(), "Bulbasaur");
        assertEquals(pokemonController.addPokemon(pokemon).getSpAttack(), 4);
    }

    @Test
    public void getAllPokemonTest() {
        List<Pokemon> pokemonList = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon(2L, "Ivysaur", "Grass, Poison", 1, 2, 3, 4, 5, 6);
        Pokemon pokemon2 = new Pokemon(3L, "Venusaur", "Grass, Poison", 1, 2, 3, 4, 5, 6);

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);

        when(repository.findAll()).thenReturn(pokemonList);

        assertEquals(pokemonController.listAllPokemon().get(0).getId(), new Long(2L));
        assertEquals(pokemonController.listAllPokemon().get(0).getSpDefence(), 5);
        assertEquals(pokemonController.listAllPokemon().get(1).getType(), "Grass, Poison");
        assertEquals(pokemonController.listAllPokemon().get(1).getDefence(), 3);
    }

    @Test
    public void getByIdTest() {
        Pokemon pokemon = new Pokemon(8L, "Wartortle", "Water", 1, 2, 3, 4, 5, 6);
        when(repository.findOne(8L)).thenReturn(pokemon);
        assertEquals(pokemonController.getPokemonById(8L).getName(), "Wartortle");
    }

    @Test
    public void deletePokemonTest() {
        Pokemon pokemon = new Pokemon(6L, "Charizard", "Fire, Flying", 1, 2, 3, 4, 5, 6);

        when(repository.findOne(6L)).thenReturn(pokemon);
        assertEquals(pokemonController.deletePokemon(6L).getType(), "Fire, Flying");
    }

    @Test
    public void getByNameTest() {
        Pokemon pokemon = new Pokemon(7L, "Squirtle", "Water", 1, 2, 3, 4, 5, 6);
        when(repository.findByName("Squirtle")).thenReturn(pokemon);
        assertEquals(pokemonController.getPokemonByName("Squirtle").getSpeed(), 6);
    }

}
