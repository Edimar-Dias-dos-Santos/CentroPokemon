package com.API.CentroPokemon.leito;

import com.API.CentroPokemon.exceptions.LeitoServiceException;
import com.API.CentroPokemon.exceptions.NotFoundException;
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
public class LeitoService {

    private LeitoRepository leitoRepository;

    public Leito criarLeito(LeitoRepresentation.CriarOuAtualizar criar) {

        if(Objects.isNull(criar.getNumeroLeito())) {
            log.error(criar.toString());
            throw new LeitoServiceException("O número não pode ser nulo");
        }
        if(criar.getNumeroLeito() <= 0) {
            log.error(criar.toString());
            throw new LeitoServiceException("O número não pode ser zero");
        }

        return this.leitoRepository.save(Leito.builder()
                .numeroLeito(criar.getNumeroLeito())
                .build());
    }


    public Page<Leito> buscarTodos(Pageable pageable) {
        return this.leitoRepository.findAll(pageable);
    }

    public Page<Leito> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.leitoRepository.findAll(filtroURI, pageable);
    }

    public Leito atualizar(
            Long idLeito,
            LeitoRepresentation.CriarOuAtualizar atualizar) {

        this.getLeito(idLeito);

        Leito leitoParaAtualizar = Leito.builder()
                .idLeito(idLeito)
                .numeroLeito(atualizar.getNumeroLeito())
                .tipoLeito(atualizar.getTipoLeito())
                .build();

        return this.leitoRepository.save(leitoParaAtualizar);

    }


    public Leito buscarUmLeito(Long idLeito) {

        return this.getLeito(idLeito);

    }


    private Leito getLeito(Long idLeito) {
        Optional<Leito> leitoAtual =
                this.leitoRepository.findById(idLeito);

        if (leitoAtual.isPresent()) {
            return leitoAtual.get();
        } else {
            throw new NotFoundException("Leito não encontrado");
        }
    }
}
