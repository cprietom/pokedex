package com.heytrade.pokemonrest.domain.ports.primary;

import com.heytrade.pokemonrest.domain.model.Pokemon;
import com.heytrade.pokemonrest.domain.model.PokemonFilter;
import com.heytrade.pokemonrest.domain.model.UpdatePokemon;

import java.util.List;

/**
 * Puerto primario.
 * Los puertos primarios serían la capa de servicio, la capa de lógica y negocio,
 * donde haríamos toda nuestra infraestructura, en la que trabajaríamos con objeto
 * de dominio.
 */
public interface PokemonDao {
    Pokemon findById(Long id);

    List<Pokemon> findByFilter(PokemonFilter pokemonFilter);

    Pokemon update(UpdatePokemon updatePokemon);
}
