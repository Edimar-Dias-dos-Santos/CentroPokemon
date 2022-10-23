package com.API.CentroPokemon.prontuario;

import com.API.CentroPokemon.treinador.Treinador;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProntuarioRepository extends PagingAndSortingRepository<Prontuario, Long>,
        QuerydslPredicateExecutor<Prontuario> {

    List<Prontuario> findAll();
}
