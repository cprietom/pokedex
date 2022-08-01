package com.heytrade.pokemonrest.persistence.mapper;

import com.heytrade.pokemonrest.dto.PokemonDTO;
import com.heytrade.pokemonrest.persistence.PokemonTypeEnum;
import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import com.heytrade.pokemonrest.persistence.entity.PokemonType;
import com.heytrade.pokemonrest.persistence.repository.PokemonTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PokemonMapper {
    private static final Logger log = LoggerFactory.getLogger(PokemonMapper.class);
    public PokemonDTO entityToDTO(Pokemon pokemon) {
        if (Objects.isNull(pokemon)) {
            return null;
        }

        PokemonDTO pokemonDTO = new PokemonDTO();

        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setTypes(pokemon.getTypes().stream().map(type -> PokemonTypeEnum.valueOf(type.getType())).collect(Collectors.toList()));
        pokemonDTO.setFavorite(pokemon.getFavorite());

        return pokemonDTO;
    }
}
