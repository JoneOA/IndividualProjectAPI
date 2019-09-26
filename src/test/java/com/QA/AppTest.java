package com.QA;


import com.QA.controller.InventoryController;
import com.QA.model.Inventory;
import com.QA.model.Pokemon;
import com.QA.repository.InventoryRepository;
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
public class AppTest
{

    @InjectMocks
    private InventoryController inventoryController;

    @Mock
    private InventoryRepository inventoryRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addPokemonTest() {
        Inventory pokemon = new Inventory(1L, "Bulbasaur", "Grass", 1, 2, 3, 4, 5, 6);
        when(inventoryRepository.saveAndFlush(pokemon)).thenReturn(pokemon);
        assertEquals(inventoryController.addPokemon(pokemon).getName(), "Bulbasaur");
        assertEquals(inventoryController.addPokemon(pokemon).getSpAttack(), 4);
    }

    @Test
    public void getAllPokemonTest() {
        List<Inventory> pokemonList = new ArrayList<>();

        Inventory pokemon1 = new Inventory(2L, "Ivysaur", "Grass, Poison", 1, 2, 3, 4, 5, 6);
        Inventory pokemon2 = new Inventory(3L, "Venusaur", "Grass, Poison", 1, 2, 3, 4, 5, 6);

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);

        when(inventoryRepository.findAll()).thenReturn(pokemonList);

        assertEquals(inventoryController.listAllPokemon().get(0).getId(), new Long(2L));
        assertEquals(inventoryController.listAllPokemon().get(0).getSpDefence(), 5);
        assertEquals(inventoryController.listAllPokemon().get(1).getType(), "Grass, Poison");
        assertEquals(inventoryController.listAllPokemon().get(1).getDefence(), 3);
    }

    @Test
    public void updatePokemonTest() {
        Inventory pokemon1 = new Inventory(4L, "Charamder", "Fire", 1, 2, 3, 4, 5, 6);
        Inventory pokemon2 = new Inventory(5L, "Charmeleon", "Fire, Flying", 1, 2, 3, 4, 5, 6);

        when(inventoryRepository.findOne(4L)).thenReturn(pokemon1);
        when(inventoryRepository.saveAndFlush(pokemon1)).thenReturn(pokemon1);

        assertEquals(inventoryController.updatePokemon(4L, pokemon2).getName(), "Charmeleon");
    }


    @Test
    public void deletePokemonTest() {
        Inventory pokemon = new Inventory(6L, "Charizard", "Fire, Flying", 1, 2, 3, 4, 5, 6);

        when(inventoryRepository.findOne(6L)).thenReturn(pokemon);
        assertEquals(inventoryController.deletePokemon(6L).getType(), "Fire, Flying");
    }

    App app;

    @Test
    public void mainAppTest()
    {
        app = new App();
        app.main(new String[]{});
        assertTrue( true );
    }

    private void assertTrue(boolean b) {
    }
}
