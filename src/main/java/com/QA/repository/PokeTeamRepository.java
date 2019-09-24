package com.QA.repository;

import com.QA.model.PokeTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeTeamRepository extends JpaRepository<PokeTeam, Long> {
    PokeTeam findByName(String name);
}

