package com.heytrade.pokemonrest.infrastructure.adapters.api;

import com.heytrade.pokemonrest.application.PokemonService;
import com.heytrade.pokemonrest.application.dto.PokemonDTO;
import com.heytrade.pokemonrest.application.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.application.dto.UpdatePokemonDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Adaptador primario.
 * Los adaptadores primarios se comunican con el cliente, con el exterior,
 * y reciben las peticiones. Estos adaptadores usan, y no implementan,
 * los puertos primarios para acceder al core lógico de la aplicación.
 */
@RestController
@RequestMapping("/v1/pokedex")
public class PokemonController {
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    /**
     * Application service, NOT domain service. It is used by this controller/API_adapter
     * to access the domain logic.
     * Calling domain services directly from the controller may lead to
     * the fat controller antipattern.
     *
     * It could also have been implemented as an internal adapter service by moving
     * PokemonService and PokemonDTOMapper into the package of this controller.
     */
    private final PokemonService pokemonService;

    @Inject
    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PokemonDTO> get(@PathVariable Long id) {
        log.info("GET /v1/pokemons/{}", id);
        ResponseEntity<PokemonDTO> result = Optional.ofNullable(pokemonService.findById(id))
            .map(ResponseEntity::ok)
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
        return Optional.ofNullable(pokemonService.update(id, updatePokemonDTO))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
