package com.heytrade.pokemonrest.persistence.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="POKEMON")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean favorite;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
    private List<PokemonType> types;

    Pokemon() {}

    public Pokemon(Long id, String name, boolean favorite) {
        this.id = id;
        this.name = name;
        this.favorite = favorite;
    }
}
