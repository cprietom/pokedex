package com.heytrade.pokemonrest.service;

import com.heytrade.pokemonrest.dto.PokemonDTO;
import com.heytrade.pokemonrest.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import com.heytrade.pokemonrest.persistence.mapper.PokemonMapper;
import com.heytrade.pokemonrest.persistence.repository.PokemonCustomRepository;
import com.heytrade.pokemonrest.persistence.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    PokemonCustomRepository pokemonCustomRepository;

    @Autowired
    PokemonMapper pokemonMapper;

    public PokemonDTO findById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemonMapper.entityToDTO(pokemon.orElse(null));
    }

    public List<PokemonDTO> find(PokemonFilterDTO filterDTO) {
        List<Pokemon> pokemons = pokemonCustomRepository.findByFilter(filterDTO);
        return pokemons.stream().map(pokemon -> pokemonMapper.entityToDTO(pokemon)).collect(Collectors.toList());
    }

    public PokemonDTO update(Long id, UpdatePokemonDTO updatePokemonDTO) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isPresent()) {
            pokemon.get().setFavorite(updatePokemonDTO.getFavorite());
            pokemonRepository.save(pokemon.get());
            return pokemonMapper.entityToDTO(pokemon.get());
        } else {
            return null;
        }
    }
}
