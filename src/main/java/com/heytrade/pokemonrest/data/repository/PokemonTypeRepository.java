package com.heytrade.pokemonrest.data.repository;

import com.heytrade.pokemonrest.data.entity.PokemonTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonTypeRepository extends JpaRepository<PokemonTypeEntity, Long> {
}
