package com.heytrade.pokemonrest.data.repository;

import com.heytrade.pokemonrest.data.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
