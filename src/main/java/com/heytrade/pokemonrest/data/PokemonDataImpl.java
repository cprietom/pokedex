package com.heytrade.pokemonrest.data;

import com.heytrade.pokemonrest.data.repository.PokemonCustomRepository;
import com.heytrade.pokemonrest.data.repository.PokemonRepository;
import com.heytrade.pokemonrest.domain.Pokemon;
import com.heytrade.pokemonrest.domain.PokemonDataRepository;
import com.heytrade.pokemonrest.domain.PokemonFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonDataImpl implements PokemonDataRepository {
    PokemonRepository pokemonRepository;
    PokemonCustomRepository pokemonCustomRepository;

    PokemonDataImpl(PokemonRepository pokemonRepository) {

    }
    @Override
    public Pokemon findById(Long id) {
        return null;
    }

    @Override
    public List<Pokemon> findByFilter(PokemonFilter pokemonFilter) {
        return null;
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        return null;
    }
}
