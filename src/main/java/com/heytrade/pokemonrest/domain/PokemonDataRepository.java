package com.heytrade.pokemonrest.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PokemonDataRepository {
    Pokemon findById(Long id);

    List<Pokemon> findByFilter(PokemonFilter pokemonFilter);

    Pokemon save(Pokemon pokemon);
}
