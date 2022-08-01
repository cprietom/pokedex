package com.heytrade.pokemonrest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heytrade.pokemonrest.persistence.PokemonTypeEnum;
import com.heytrade.pokemonrest.persistence.entity.PokemonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonFilterDTO {
    private String name;
    private PokemonTypeEnum type;
    private Boolean favorite;
}
