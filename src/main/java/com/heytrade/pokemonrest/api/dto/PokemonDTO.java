package com.heytrade.pokemonrest.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heytrade.pokemonrest.domain.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonDTO {
    private long id;
    private String name;
    private List<PokemonTypeEnum> types;
    private boolean favorite;

    public void setName(String name) {
        this.name = name;
    }
}
