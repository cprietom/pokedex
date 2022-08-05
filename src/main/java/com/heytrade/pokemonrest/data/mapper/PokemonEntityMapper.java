package com.heytrade.pokemonrest.data.mapper;

import com.heytrade.pokemonrest.domain.Pokemon;
import com.heytrade.pokemonrest.domain.PokemonTypeEnum;
import com.heytrade.pokemonrest.data.entity.PokemonEntity;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PokemonEntityMapper {

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

//    public PokemonEntity toEntity(Pokemon pokemon) {
//        if (Objects.isNull(pokemon)) {
//            return null;
//        }
//
//        PokemonDTO pokemonDTO = new PokemonDTO();
//
//        pokemonDTO.setId(pokemon.getId());
//        pokemonDTO.setName(pokemon.getName());
//        pokemonDTO.setTypes(pokemon.getTypes().stream().map(type -> PokemonTypeEnum.valueOf(type.getType())).collect(Collectors.toList()));
//        pokemonDTO.setFavorite(pokemon.getFavorite());
//
//        return pokemonDTO;
//    }
}
