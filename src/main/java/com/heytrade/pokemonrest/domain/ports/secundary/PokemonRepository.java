package com.heytrade.pokemonrest.domain.ports.secundary;

import com.heytrade.pokemonrest.domain.model.Pokemon;

public interface PokemonRepository  {
    Pokemon save(Pokemon pokemon);
}
