package com.QA.repository;

import com.QA.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepositoryId extends JpaRepository<Pokemon, Long>{
}
