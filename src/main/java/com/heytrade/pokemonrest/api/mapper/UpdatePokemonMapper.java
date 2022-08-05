package com.heytrade.pokemonrest.api.mapper;

import com.heytrade.pokemonrest.api.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.domain.UpdatePokemon;
import org.springframework.stereotype.Component;

@Component
public class UpdatePokemonMapper {
    public UpdatePokemon fromDTO(UpdatePokemonDTO updatePokemonDTO) {
        UpdatePokemon updatePokemon = new UpdatePokemon();
        updatePokemon.setFavorite(updatePokemonDTO.getFavorite());
        return updatePokemon;
    }
}
