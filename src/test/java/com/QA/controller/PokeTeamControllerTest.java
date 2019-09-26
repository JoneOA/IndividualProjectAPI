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
}
