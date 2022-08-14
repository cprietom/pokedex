package com.heytrade.pokemonrest.application;

import com.heytrade.pokemonrest.application.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.domain.model.PokemonFilter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
class PokemonFilterDTOMapper {
    public PokemonFilter fromDTO(PokemonFilterDTO pokemonFilterDTO) {
        if (Objects.isNull(pokemonFilterDTO)) {
            return null;
        }

        PokemonFilter pokemonFilter = new PokemonFilter();

        pokemonFilter.setName(pokemonFilterDTO.getName());
        pokemonFilter.setFavorite(pokemonFilterDTO.getFavorite());
        pokemonFilter.setType(pokemonFilterDTO.getType());

        return pokemonFilter;
    }
}
