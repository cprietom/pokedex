package com.heytrade.pokemonrest.infrastructure.adapters.pokemon.repository.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "POKEMON")
public class PokemonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean favorite;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
    private List<PokemonTypeEntity> types;

    PokemonEntity() {
    }

    public PokemonEntity(Long id, String name, boolean favorite) {
        this.id = id;
        this.name = name;
        this.favorite = favorite;
    }
}
