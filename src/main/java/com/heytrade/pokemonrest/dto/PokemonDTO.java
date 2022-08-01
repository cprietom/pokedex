package com.heytrade.pokemonrest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heytrade.pokemonrest.persistence.PokemonTypeEnum;
import com.heytrade.pokemonrest.persistence.entity.PokemonType;
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
