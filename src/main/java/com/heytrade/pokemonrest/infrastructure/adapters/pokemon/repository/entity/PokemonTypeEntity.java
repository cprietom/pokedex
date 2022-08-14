package com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "POKEMON_TYPE")
public class PokemonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POKEMON_ID", nullable = false)
    private PokemonEntity pokemon;

    @Column(name = "POKEMON_TYPE", nullable = false)
    private String type;

    public PokemonTypeEntity() {
    }

    public PokemonTypeEntity(PokemonEntity pokemon, String type) {
        this.pokemon = pokemon;
        this.type = type;
    }

}
