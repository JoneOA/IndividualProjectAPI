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
