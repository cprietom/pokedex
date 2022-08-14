package com.heytrade.pokemonrest.infrastructure.adapters.pokemon;

import com.heytrade.pokemonrest.domain.model.Pokemon;
import com.heytrade.pokemonrest.domain.model.PokemonFilter;
import com.heytrade.pokemonrest.domain.model.UpdatePokemon;
import com.heytrade.pokemonrest.domain.ports.primary.PokemonDao;
import com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity.PokemonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Adaptador secundario.
 * Los adaptadores secundarios son la implementación de los puertos
 * secundarios que acceden a la base de datos,
 * a bases de datos de caché y a otros microservicios o sistemas en red.
 */
@Component
public class PokemonDaoAdapter implements PokemonDao {
    // Puerto y, a la vez, adaptador secundario para acceder a la capa de persistencia
    PokemonRepository pokemonRepository;
    PokemonCustomRepository pokemonCustomRepository;
    PokemonEntityMapper pokemonEntityMapper;

    public PokemonDaoAdapter(PokemonRepository pokemonRepository,
                             PokemonCustomRepository pokemonCustomRepository,
                             PokemonEntityMapper pokemonEntityMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonCustomRepository = pokemonCustomRepository;
        this.pokemonEntityMapper = pokemonEntityMapper;
    }
    @Override
    public Pokemon findById(Long id) {
        //TODO: Llamar a un puerto secundario para
        return pokemonRepository.findById(id)
                .map(pokemonEntity -> pokemonEntityMapper.fromEntity(pokemonEntity))
                .orElse(null);
    }

    @Override
    public List<Pokemon> findByFilter(PokemonFilter pokemonFilter) {
        return pokemonCustomRepository.findByFilter(pokemonFilter)
                .stream().map(
                        pokemonEntity -> pokemonEntityMapper.fromEntity(pokemonEntity)).collect(Collectors.toList());
    }

    @Override
    public Pokemon update(UpdatePokemon updatePokemon) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(updatePokemon.getId()).orElse(null);
        if (Objects.nonNull(pokemonEntity)) {
            pokemonEntity.setFavorite(updatePokemon.getFavorite());
            return pokemonEntityMapper.fromEntity(pokemonRepository.save(pokemonEntity));
        } else {
            return null;
        }
    }
}
