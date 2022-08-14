package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface PokemonTypeRepository extends JpaRepository<PokemonTypeEntity, Long> {
}
