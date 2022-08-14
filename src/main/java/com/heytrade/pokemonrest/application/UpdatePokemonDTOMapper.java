package com.heytrade.pokemonrest.application;

import com.heytrade.pokemonrest.application.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.domain.model.UpdatePokemon;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
class UpdatePokemonDTOMapper {
    public UpdatePokemon fromDTO(Long id, UpdatePokemonDTO udpatePokemonDTO) {
        if (Objects.isNull(id) || Objects.isNull(udpatePokemonDTO)) {
            return null;
        }

        UpdatePokemon updatePokemon = new UpdatePokemon();

        updatePokemon.setId(id);
        updatePokemon.setFavorite(udpatePokemonDTO.getFavorite());

        return updatePokemon;
    }
}
