package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.domain.model.PokemonFilter;
import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PokemonCustomRepository {
    List<PokemonEntity> findByFilter(PokemonFilter pokemonFilter);
}
