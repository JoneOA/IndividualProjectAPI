package com.QA.controller;

import com.QA.model.Pokemon;
import com.QA.repository.PokemonRepositoryId;
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
    private PokemonRepositoryId repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pokemon = new Pokemon();

        pokemon.setAttack(66);
        pokemon.setDefence(66);
        pokemon.setHP(100);
        pokemon.setId((long) 1);
        pokemon.setName("Bulbasaur");
        pokemon.setSpAttack(66);
        pokemon.setSpDefence(66);
        pokemon.getSpeed(66);
        pokemon.setType("Grass");

        pokemonList.add(pokemon);

        when(repository.findAll()).thenReturn(pokemonList);
        assertEquals(
                (long)pokemonController.listAllPokemon().get(0).getId(),
                (long)1
        );
    }



}
