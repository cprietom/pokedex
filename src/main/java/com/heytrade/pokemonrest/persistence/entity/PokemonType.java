package com.heytrade.pokemonrest.persistence.entity;

import com.heytrade.pokemonrest.persistence.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="POKEMON_TYPE")
public class PokemonType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POKEMON_ID", nullable = false)
    private Pokemon pokemon;

    @Column(name = "POKEMON_TYPE", nullable = false)
    private String type;

    public PokemonType() {
    }

    public PokemonType(Long id, Pokemon pokemon, String type) {
        this.id = id;
        this.pokemon = pokemon;
        this.type = type;
    }

}
