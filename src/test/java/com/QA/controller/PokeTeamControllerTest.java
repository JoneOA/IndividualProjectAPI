package com.QA.controller;

import com.QA.model.PokeTeam;
import com.QA.repository.PokeTeamRepository;
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
public class PokeTeamControllerTest {

    @InjectMocks
    private PokeTeamController pokeTeamController;

    @Mock
    private PokeTeamRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addPokemonTest() {
        PokeTeam pokemon = new PokeTeam(1L, 1L, "Bulbasaur");
        when(repository.saveAndFlush(pokemon)).thenReturn(pokemon);
        assertEquals(pokeTeamController.addPokemon(pokemon).getName(), "Bulbasaur");
    }

    @Test
    public void getAllPokemonTest() {
        List<PokeTeam> pokemonList = new ArrayList<>();

        PokeTeam pokemon1 = new PokeTeam(1L,2L, "Ivysaur");
        PokeTeam pokemon2 = new PokeTeam(2L, 3L, "Venusaur");

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);

        when(repository.findAll()).thenReturn(pokemonList);

        assertEquals(pokeTeamController.listAllPokemon().get(0).getId(), new Long(1L));
        assertEquals(pokeTeamController.listAllPokemon().get(0).getName(), "Ivysaur");
        assertEquals(pokeTeamController.listAllPokemon().get(1).getPokeId(), new Long(3L));
        assertEquals(pokeTeamController.listAllPokemon().get(1).getId(), new Long(2L));
    }

    @Test
    public void updatePokemonTest() {
        PokeTeam pokemon1 = new PokeTeam(1L ,4L, "Charamder");
        PokeTeam pokemon2 = new PokeTeam(2L,5L, "Charmeleon");

        when(repository.findOne(1L)).thenReturn(pokemon1);
        when(repository.saveAndFlush(pokemon1)).thenReturn(pokemon1);

        assertEquals(pokeTeamController.updatePokemon(1L, pokemon2).getName(), "Charmeleon");
    }
}
