package com.QA.repository;

import com.QA.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

    Pokemon findByName(String name);
}
