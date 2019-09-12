package com.QA.repository;

import com.QA.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepositoryName extends JpaRepository<Pokemon, String> {
}
