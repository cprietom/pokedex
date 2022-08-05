package com.heytrade.pokemonrest.data.repository;

import com.heytrade.pokemonrest.domain.PokemonFilter;
import com.heytrade.pokemonrest.data.entity.PokemonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonCustomRepository {
    List<PokemonEntity> findByFilter(PokemonFilter pokemonFilter);
}
