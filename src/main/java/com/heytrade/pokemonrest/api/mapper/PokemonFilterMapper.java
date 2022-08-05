package com.heytrade.pokemonrest.api.mapper;

import com.heytrade.pokemonrest.api.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.domain.PokemonFilter;
import org.springframework.stereotype.Component;

@Component
public class PokemonFilterMapper {
    public PokemonFilter fromDTO(PokemonFilterDTO pokemonFilterDTO) {
        PokemonFilter pokemonFilter = new PokemonFilter();
        pokemonFilter.setName(pokemonFilterDTO.getName());
        pokemonFilter.setType(pokemonFilterDTO.getType());
        pokemonFilter.setFavorite(pokemonFilterDTO.getFavorite());
        return pokemonFilter;
    }
}
