package com.API.CentroPokemon.prontuario;

import com.API.CentroPokemon.exceptions.NotFoundException;
import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepresentation;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProntuarioService {

    private ProntuarioRepository prontuarioRepository;

    public Prontuario criarProntuario(ProntuarioRepresentation.CriarOuAtualizar criar) {

        return this.prontuarioRepository.save(Prontuario.builder()
                .descricaoProntuario(criar.getDescricaoProntuario())
                .nomeMedico(criar.getNomeMedico())
                .build());
    }


    public Page<Prontuario> buscarTodos(Pageable pageable) {return this.prontuarioRepository.findAll(pageable);
    }

    public Page<Prontuario> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.prontuarioRepository.findAll(filtroURI, pageable);
    }

    public Prontuario atualizar(
            Long idProntuario,
            ProntuarioRepresentation.CriarOuAtualizar atualizar) {

        this.getProntuario(idProntuario);

        Prontuario prontuarioParaAtualizar = Prontuario.builder()
                .idProntuario(idProntuario)
                .descricaoProntuario(atualizar.getDescricaoProntuario())
                .nomeMedico(atualizar.getNomeMedico())
                .build();

        return this.prontuarioRepository.save(prontuarioParaAtualizar);

    }


    public Prontuario buscarUmProntuario(Long idProntuario) {

        return this.getProntuario(idProntuario);

    }


    private Prontuario getProntuario(Long idProntuario) {
        Optional<Prontuario> prontuarioAtual =
                this.prontuarioRepository.findById(idProntuario);

        if (prontuarioAtual.isPresent()) {
            return prontuarioAtual.get();
        } else {
            throw new NotFoundException("Prontuario não encontrado");
        }
    }
}
