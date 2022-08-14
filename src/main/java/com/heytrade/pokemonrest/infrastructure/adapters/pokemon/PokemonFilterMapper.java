package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.application.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.domain.model.PokemonFilter;
import org.springframework.stereotype.Component;

@Component
class PokemonFilterMapper {
    public PokemonFilter fromDTO(PokemonFilterDTO pokemonFilterDTO) {
        PokemonFilter pokemonFilter = new PokemonFilter();
        pokemonFilter.setName(pokemonFilterDTO.getName());
        pokemonFilter.setType(pokemonFilterDTO.getType());
        pokemonFilter.setFavorite(pokemonFilterDTO.getFavorite());
        return pokemonFilter;
    }
}
