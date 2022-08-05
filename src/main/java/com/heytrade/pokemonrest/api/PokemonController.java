package com.heytrade.pokemonrest.api;

import com.heytrade.pokemonrest.api.dto.PokemonDTO;
import com.heytrade.pokemonrest.api.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.api.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.api.mapper.PokemonFilterMapper;
import com.heytrade.pokemonrest.api.mapper.PokemonDTOMapper;
import com.heytrade.pokemonrest.api.mapper.UpdatePokemonMapper;
import com.heytrade.pokemonrest.domain.Pokemon;
import com.heytrade.pokemonrest.domain.PokemonFilter;
import com.heytrade.pokemonrest.domain.UpdatePokemon;
import com.heytrade.pokemonrest.service.PokemonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/v1/pokedex")
public class PokemonController {
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    PokemonService pokemonService;

    PokemonDTOMapper pokemonDTOMapper;

    PokemonFilterMapper pokemonFilterMapper;

    UpdatePokemonMapper updatePokemonMapper;

    @Inject
    PokemonController(PokemonService pokemonService,
                      PokemonDTOMapper pokemonDTOMapper,
                      PokemonFilterMapper pokemonFilterMapper,
                      UpdatePokemonMapper updatePokemonMapper) {
        this.pokemonService = pokemonService;
        this.pokemonDTOMapper = pokemonDTOMapper;
        this.pokemonFilterMapper = pokemonFilterMapper;
        this.updatePokemonMapper = updatePokemonMapper;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PokemonDTO> get(@PathVariable Long id) {
        log.info("GET /v1/pokemons/{}", id);
        ResponseEntity<PokemonDTO> result = Optional.ofNullable(pokemonService.findById(id))
            .map(pokemon -> ResponseEntity.ok(pokemonDTOMapper.toDTO(pokemon)))
            .orElseGet(() -> ResponseEntity.notFound().build());
        log.info("result: {}", result);
        return result;
    }

    @GetMapping
    ResponseEntity<List<PokemonDTO>> filter(@ModelAttribute PokemonFilterDTO filterDTO) {
        PokemonFilter pokemonFilter = pokemonFilterMapper.fromDTO(filterDTO);
        List<Pokemon> pokemons = pokemonService.find(pokemonFilter);
        if (pokemons.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            List<PokemonDTO> pokemonDTOS = pokemons.stream().map(pokemon -> pokemonDTOMapper.toDTO(pokemon)).collect(Collectors.toList());
            return ResponseEntity.ok(pokemonDTOS);
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PokemonDTO> update(@PathVariable(required = true) Long id, @RequestBody(required = true) UpdatePokemonDTO updatePokemonDTO) {
        UpdatePokemon updatePokemon = updatePokemonMapper.fromDTO(updatePokemonDTO);
        return Optional.ofNullable(pokemonService.update(id, updatePokemon))
                .map(pokemon -> ResponseEntity.ok(pokemonDTOMapper.toDTO(pokemon)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
