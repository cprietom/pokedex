package com.heytrade.pokemonrest.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heytrade.pokemonrest.domain.model.PokemonTypeEnum;
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
    private Boolean favorite;

    public void setName(String name) {
        this.name = name;
    }
}
