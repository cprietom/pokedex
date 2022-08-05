package com.heytrade.pokemonrest.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonFilter {
    private String name;
    private PokemonTypeEnum type;
    private Boolean favorite;
}
