package com.API.CentroPokemon.treinador;

import com.API.CentroPokemon.exceptions.NotFoundException;
import com.API.CentroPokemon.exceptions.TreinadorServiceException;

import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TreinadorService {

    private TreinadorRepository treinadorRepository;

    public Treinador criarTreinador(TreinadorRepresentation.CriarOuAtualizar criar) {

        return this.treinadorRepository.save(Treinador.builder()
                .nomeTreinador(criar.getNomeTreinador())
                .rgTreinador(criar.getRgTreinador())
                .statusTreinador(criar.getStatusTreinador())
                .build());
    }

    public Page<Treinador> buscarTodos(Pageable pageable) {
        return this.treinadorRepository.findAll(pageable);
    }

    public Page<Treinador> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.treinadorRepository.findAll(filtroURI, pageable);
    }

    public Treinador atualizar(
            Long idTreinador,
            TreinadorRepresentation.CriarOuAtualizar atualizar) {

        this.getTreinador(idTreinador);

        Treinador treinadorParaAtualizar = Treinador.builder()
                .idTreinador(idTreinador)
                .nomeTreinador(atualizar.getNomeTreinador())
                .rgTreinador(atualizar.getRgTreinador())
                .statusTreinador(atualizar.getStatusTreinador())
                .build();

        return this.treinadorRepository.save(treinadorParaAtualizar);

    }

    public Treinador buscarUmTreinador(Long idTreinador) {

        return this.getTreinador(idTreinador);

    }

    private Treinador getTreinador(Long idTreinador) {
        Optional<Treinador> treinadorAtual =
                this.treinadorRepository.findById(idTreinador);

        if (treinadorAtual.isPresent()) {
            return treinadorAtual.get();
        } else {
            throw new NotFoundException("Treinador não encontrado");
        }
    }
}

