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

        if(Objects.isNull(criar.getNomeTreinador())) {
            log.error(criar.toString());
            throw new TreinadorServiceException("O nome não pode ser nulo");
        }
        if(criar.getNomeTreinador().isEmpty()) {
            log.error(criar.toString());
            throw new TreinadorServiceException("O nome não pode ser vazio");
        }

        if(Objects.isNull(criar.getRgTreinador())) {
            log.error(criar.toString());
            throw new TreinadorServiceException("O rg não pode ser nulo");
        }
        if(criar.getRgTreinador().isEmpty()) {
            log.error(criar.toString());
            throw new TreinadorServiceException("O rg não pode ser vazio");
        }
        return this.treinadorRepository.save(Treinador.builder()
                .nomeTreinador(criar.getNomeTreinador())
                .rgTreinador(criar.getRgTreinador())
                .build());
    }

    public Page<Treinador> buscarTodos(org.springframework.cglib.core.Predicate filtroURI, Pageable pageable) {
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

