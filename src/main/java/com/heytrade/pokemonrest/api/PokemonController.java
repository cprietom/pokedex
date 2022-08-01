package com.heytrade.pokemonrest.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.heytrade.pokemonrest.dto.PokemonDTO;
import com.heytrade.pokemonrest.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.dto.UpdatePokemonDTO;
import com.heytrade.pokemonrest.persistence.repository.PokemonRepository;
import com.heytrade.pokemonrest.service.PokemonService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/v1/pokedex")
public class PokemonController {
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    PokemonService pokemonService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PokemonDTO> get(@PathVariable Long id) {
        log.info("GET /v1/pokemons/{}", id);
        ResponseEntity<PokemonDTO> result = Optional.ofNullable(pokemonService.findById(id))
            .map(pokemon -> ResponseEntity.ok(pokemon))
            .orElseGet(() -> ResponseEntity.notFound().build());
        log.info("result: {}", result);
        return result;
    }

    @GetMapping
    ResponseEntity<List<PokemonDTO>> filter(@ModelAttribute PokemonFilterDTO filterDTO) {
        List<PokemonDTO> pokemons = pokemonService.find(filterDTO);
        if (pokemons.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pokemons);
        }
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PokemonDTO> update(@PathVariable(required = true) Long id, @RequestBody(required = true) UpdatePokemonDTO updatePokemonDTO) {
        PokemonDTO pokemonDTO = pokemonService.update(id, updatePokemonDTO);
        return ResponseEntity.ok(pokemonDTO);
    }
}
