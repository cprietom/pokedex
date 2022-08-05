package com.heytrade.pokemonrest.data.repository;

import com.heytrade.pokemonrest.data.entity.PokemonEntity;
import com.heytrade.pokemonrest.data.entity.PokemonTypeEntity;
import com.heytrade.pokemonrest.domain.PokemonFilter;

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

    public List<PokemonEntity> findByFilter(PokemonFilter pokemonFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PokemonEntity> query = criteriaBuilder.createQuery(PokemonEntity.class);
        Root<PokemonEntity> pokemon = query.from(PokemonEntity.class);
        query.select(pokemon);
        query.where(createPredicateFromFilter(criteriaBuilder, pokemon, pokemonFilter));

        return entityManager.createQuery(query).getResultList();
    }

    private Predicate createPredicateFromFilter(CriteriaBuilder criteriaBuilder,
                                                Root<PokemonEntity> pokemon,
                                                PokemonFilter pokemonFilter) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(pokemonFilter.getName())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(pokemon.get("name")), pokemonFilter.getName().toUpperCase() + "%"));
        }

        if (Objects.nonNull(pokemonFilter.getType())) {
            Join<PokemonEntity, PokemonTypeEntity> types = pokemon.join("types");
            predicates.add(criteriaBuilder.equal(types.get("type"), pokemonFilter.getType().toString()));
        }

        if (Objects.nonNull(pokemonFilter.getFavorite())) {
            predicates.add(criteriaBuilder.equal(pokemon.get("favorite"), pokemonFilter.getFavorite()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
