package com.heytrade.pokemonrest.persistence.repository;

import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
