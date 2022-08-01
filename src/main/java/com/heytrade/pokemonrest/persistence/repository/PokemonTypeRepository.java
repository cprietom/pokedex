package com.heytrade.pokemonrest.persistence.repository;

import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import com.heytrade.pokemonrest.persistence.entity.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long> {
}
