package com.API.CentroPokemon.leito;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LeitoRepository extends PagingAndSortingRepository<Leito, Long>,
        QuerydslPredicateExecutor<Leito> {

    List<Leito> findAll();
}
