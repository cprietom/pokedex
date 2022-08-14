package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.domain.model.Pokemon;
import com.heytrade.pokemonrest.domain.model.PokemonTypeEnum;
import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonEntity;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
class PokemonEntityMapper {

    // TODO: entity es el DTO de la capa data
    public Pokemon fromEntity(PokemonEntity pokemonEntity) {
        if (Objects.isNull(pokemonEntity)) {
            return null;
        }
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonEntity.getId());
        pokemon.setName(pokemonEntity.getName());
        pokemon.setFavorite(pokemonEntity.getFavorite());
        pokemon.setTypes(pokemonEntity.getTypes().stream().map(type -> PokemonTypeEnum.valueOf(type.getType())).collect(Collectors.toList()));

        return pokemon;
    }

    public PokemonEntity toEntity(Pokemon pokemon) {
        if (Objects.isNull(pokemon)) {
            return null;
        }

        return new PokemonEntity(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getFavorite()
        );
    }
}
