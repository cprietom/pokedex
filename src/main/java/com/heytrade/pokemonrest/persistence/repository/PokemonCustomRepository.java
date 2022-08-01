package com.heytrade.pokemonrest.persistence.repository;

import com.heytrade.pokemonrest.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonCustomRepository {
    List<Pokemon> findByFilter(PokemonFilterDTO pokemonFilterDTO);
}
