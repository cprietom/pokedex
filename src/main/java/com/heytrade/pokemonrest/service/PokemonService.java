package com.heytrade.pokemonrest.service;

import com.heytrade.pokemonrest.data.entity.PokemonEntity;
import com.heytrade.pokemonrest.data.mapper.PokemonEntityMapper;
import com.heytrade.pokemonrest.data.repository.PokemonCustomRepository;
import com.heytrade.pokemonrest.data.repository.PokemonRepository;
import com.heytrade.pokemonrest.domain.Pokemon;
import com.heytrade.pokemonrest.domain.PokemonDataRepository;
import com.heytrade.pokemonrest.domain.PokemonFilter;
import com.heytrade.pokemonrest.domain.UpdatePokemon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    PokemonRepository pokemonRepository;
    PokemonCustomRepository pokemonCustomRepository;

    PokemonDataRepository pokemonDataRepository;

    PokemonEntityMapper pokemonEntityMapper;
    @Inject
    PokemonService(PokemonRepository pokemonRepository,
                   PokemonCustomRepository pokemonCustomRepository,
                   PokemonEntityMapper pokemonEntityMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonCustomRepository = pokemonCustomRepository;
        this.pokemonEntityMapper = pokemonEntityMapper;
    }

    public Pokemon findById(Long id) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(id).orElse(null);
        return pokemonEntityMapper.fromEntity(pokemonEntity);
    }

    public List<Pokemon> find(PokemonFilter pokemonFilter) {
        List<PokemonEntity> pokemonEntity = pokemonCustomRepository.findByFilter(pokemonFilter);
        return pokemonEntity.stream().map(pokemonEntity1 -> pokemonEntityMapper.fromEntity(pokemonEntity1)).collect(Collectors.toList());
    }

    public Pokemon update(Long id, UpdatePokemon updatePokemon) {
        Optional<PokemonEntity> pokemonEntity = pokemonRepository.findById(id);
        if (pokemonEntity.isPresent()) {
            pokemonEntity.get().setFavorite(updatePokemon.getFavorite());
            PokemonEntity pokemonEntity1 = pokemonRepository.save(pokemonEntity.get());
            return pokemonEntityMapper.fromEntity(pokemonEntity1);
        } else {
            return null;
        }
    }
}
