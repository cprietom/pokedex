package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.domain.model.Pokemon;
import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonEntity;
import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonTypeEntity;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonRepositoryAdapter implements com.heytrade.pokemonrest.domain.ports.secundary.PokemonRepository {
    PokemonRepository pokemonRepository;
    PokemonTypeRepository pokemonTypeRepository;
    PokemonEntityMapper pokemonEntityMapper;

    @Inject
    public PokemonRepositoryAdapter(PokemonRepository pokemonRepository,
                                    PokemonTypeRepository pokemonTypeRepository,
                                    PokemonEntityMapper pokemonEntityMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.pokemonEntityMapper = pokemonEntityMapper;
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        // Persist pokemon entity
        PokemonEntity pokemonEntity = pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));

        // Persist pokemon entity types
        List<PokemonTypeEntity> pokemonTypeEntities =
                pokemon.getTypes().stream().map(
                                pokemonTypeEnum -> new PokemonTypeEntity(pokemonEntity, pokemonTypeEnum.toString()))
                        .collect(Collectors.toList());
        pokemonTypeEntities.stream().forEach(pokemonTypeEntity -> pokemonTypeRepository.save(pokemonTypeEntity));

        // Build DTO to return
        return pokemonEntityMapper.fromEntity(pokemonEntity);
    }
}
