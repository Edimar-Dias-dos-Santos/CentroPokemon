package com.API.CentroPokemon.atendimento;
import com.API.CentroPokemon.exceptions.NotFoundException;
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
public class AtendimentoService {
    public Atendimento criarAtendimento(AtendimentoRepresentation.CriarOuAtualizar criar) {

        return this.atendimentoRepository.save(Atendimento.builder()
                .dataEntrada(criar.getDataEntrada())
                .dataSaida(criar.getDataSaida())
                .tipoAtendimento(criar.getTipoAtendimento())
                .custoAtendimento(criar.getCustoAtendimento())
                .build());
    }

    private AtendimentoRepository atendimentoRepository;

    public Page<Atendimento> buscarTodos(Pageable pageable) {
        return this.atendimentoRepository.findAll(pageable);
    }

    public Page<Atendimento> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.atendimentoRepository.findAll(filtroURI, pageable);
    }

    public Atendimento atualizar(
            Long idAtendimento,
            AtendimentoRepresentation.CriarOuAtualizar atualizar) {

        this.getAtendimento(idAtendimento);

        Atendimento atendimentoParaAtualizar = Atendimento.builder()
                .idAtendimento(idAtendimento)
                .dataEntrada(atualizar.getDataEntrada())
                .dataSaida(atualizar.getDataSaida())
                .tipoAtendimento(atualizar.getTipoAtendimento())
                .custoAtendimento(atualizar.getCustoAtendimento())
                .build();

        return this.atendimentoRepository.save(atendimentoParaAtualizar);

    }

    public Atendimento buscarUmAtendimento(Long idAtendimento) {

        return this.getAtendimento(idAtendimento);

    }

    private Atendimento getAtendimento(Long idAtendimento) {
        Optional<Atendimento> atendimentoAtual =
                this.atendimentoRepository.findById(idAtendimento);

        if (atendimentoAtual.isPresent()) {
            return atendimentoAtual.get();
        } else {
            throw new NotFoundException("Atendimento não encontrado");
        }
    }




}
