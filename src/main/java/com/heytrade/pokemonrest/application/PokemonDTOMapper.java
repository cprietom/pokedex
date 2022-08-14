package com.heytrade.pokemonrest.application;

import com.heytrade.pokemonrest.application.dto.PokemonDTO;
import com.heytrade.pokemonrest.domain.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
class PokemonDTOMapper {
    public PokemonDTO toDTO(Pokemon pokemon) {
        if (Objects.isNull(pokemon)) {
            return null;
        }

        PokemonDTO pokemonDTO = new PokemonDTO();

        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setTypes(pokemon.getTypes());
        pokemonDTO.setFavorite(pokemon.getFavorite());

        return pokemonDTO;
    }
}
