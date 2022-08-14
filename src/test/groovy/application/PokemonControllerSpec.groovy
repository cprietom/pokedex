package com.heytrade.pokemonrest.application

import com.heytrade.pokemonrest.application.dto.PokemonDTO
import com.heytrade.pokemonrest.infrastructure.adapters.api.PokemonController
import org.springframework.http.HttpStatus
import spock.lang.*


class PokemonControllerSpec extends Specification {
    @Subject
    PokemonController controller

    PokemonService service

    def setup() {
        service = Mock(PokemonService)
        controller = new PokemonController(pokemonService: service)
    }
    def "encuentro un pokemon que existe"() {
        given: "un id de pokemon que existe"
        def id = 1

        and: "un servicio que encuentra un pokemon"
        service.findById(id) >> new PokemonDTO()

        when: "busco un pokemon"
        def response = controller.get(id)

        then: "lo encuentro"
        response != null
        response.statusCode == HttpStatus.OK
    }
}