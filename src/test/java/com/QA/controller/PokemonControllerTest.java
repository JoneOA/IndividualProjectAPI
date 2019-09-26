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

import static org.assertj.core.api.Java6Assertions.assertThat;
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




}
