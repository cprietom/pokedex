package com.heytrade.pokemonrest.persistence.repository;

import com.heytrade.pokemonrest.dto.PokemonFilterDTO;
import com.heytrade.pokemonrest.persistence.entity.Pokemon;
import com.heytrade.pokemonrest.persistence.entity.PokemonType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PokemonCustomRepositoryImpl implements PokemonCustomRepository{
    @PersistenceContext
    EntityManager entityManager;

    public List<Pokemon> findByFilter(PokemonFilterDTO pokemonFilterDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pokemon> query = criteriaBuilder.createQuery(Pokemon.class);
        Root<Pokemon> pokemon = query.from(Pokemon.class);
        query.select(pokemon);
        query.where(createPredicateFromFilter(criteriaBuilder, pokemon, pokemonFilterDTO));

        return entityManager.createQuery(query).getResultList();
    }

    private Predicate createPredicateFromFilter(CriteriaBuilder criteriaBuilder,
                                                Root<Pokemon> pokemon,
                                                PokemonFilterDTO pokemonFilterDTO) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(pokemonFilterDTO.getName())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(pokemon.get("name")), pokemonFilterDTO.getName().toUpperCase() + "%"));
        }

        if (Objects.nonNull(pokemonFilterDTO.getType())) {
            Join<Pokemon, PokemonType> types = pokemon.join("types");
            predicates.add(criteriaBuilder.equal(types.get("type"), pokemonFilterDTO.getType().toString()));
        }

        if (Objects.nonNull(pokemonFilterDTO.getFavorite())) {
            predicates.add(criteriaBuilder.equal(pokemon.get("favorite"), pokemonFilterDTO.getFavorite()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
