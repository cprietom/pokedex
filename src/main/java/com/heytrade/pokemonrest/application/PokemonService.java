package com.heytrade.pokemonrest.application;

import com.heytrade.pokemonrest.application.dto.PokemonDTO;
import com.heytrade.pokemonrest.application.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.application.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.domain.model.UpdatePokemon;
import com.heytrade.pokemonrest.domain.ports.primary.PokemonDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Application service that has the responsibility of model translation and
 * orchestration (it may need other adapters).
 */
@Component
public class PokemonService {
    private PokemonDao pokemonDao;

    private PokemonDTOMapper pokemonDTOMapper;

    private PokemonFilterDTOMapper pokemonFilterDTOMapper;

    private UpdatePokemonDTOMapper updatePokemonDTOMapper;

    @Inject
    public PokemonService(PokemonDao pokemonDao,
                          PokemonDTOMapper pokemonDTOMapper,
                          PokemonFilterDTOMapper pokemonFilterDTOMapper,
                          UpdatePokemonDTOMapper updatePokemonDTOMapper) {
        this.pokemonDao = pokemonDao;
        this.pokemonDTOMapper = pokemonDTOMapper;
        this.pokemonFilterDTOMapper = pokemonFilterDTOMapper;
        this.updatePokemonDTOMapper = updatePokemonDTOMapper;
    }

    public PokemonDTO findById(Long id) {
        return pokemonDTOMapper.toDTO(pokemonDao.findById(id));
    }

    public List<PokemonDTO> find(PokemonFilterDTO pokemonFilter) {
        return pokemonDao.findByFilter(pokemonFilterDTOMapper.fromDTO(pokemonFilter)).stream()
                .map(pokemon -> pokemonDTOMapper.toDTO(pokemon))
                .collect(Collectors.toList());
    }

    public PokemonDTO update(Long id, UpdatePokemonDTO updatePokemonDTO) {
        UpdatePokemon updatePokemon = updatePokemonDTOMapper.fromDTO(id, updatePokemonDTO);
        return pokemonDTOMapper.toDTO(pokemonDao.update(updatePokemon));
    }
}
