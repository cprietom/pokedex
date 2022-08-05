package com.heytrade.pokemonrest.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="POKEMON_TYPE")
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

    public PokemonTypeEntity(Long id, PokemonEntity pokemon, String type) {
        this.id = id;
        this.pokemon = pokemon;
        this.type = type;
    }

}
