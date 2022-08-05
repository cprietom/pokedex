package com.heytrade.pokemonrest.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private Long id;
    private String name;
    private Boolean favorite;
    private List<PokemonTypeEnum> types;
}
