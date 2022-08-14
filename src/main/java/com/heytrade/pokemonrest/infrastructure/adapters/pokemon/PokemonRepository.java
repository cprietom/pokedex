package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
