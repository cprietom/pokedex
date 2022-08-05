package com.heytrade.pokemonrest.api.mapper;

import com.heytrade.pokemonrest.api.dto.PokemonDTO;
import com.heytrade.pokemonrest.domain.Pokemon;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PokemonDTOMapper {
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
