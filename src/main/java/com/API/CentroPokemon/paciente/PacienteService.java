package com.API.CentroPokemon.paciente;

import com.API.CentroPokemon.exceptions.NotFoundException;
import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepository;
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
public class PacienteService {
    public Paciente criarPaciente(PacienteRepresentation.CriarOuAtualizar criar) {

        return this.pacienteRepository.save(Paciente.builder()
                .nomePaciente(criar.getNomePaciente())
                .generoPokemon(criar.getGeneroPokemon())
                .tipoPokemon(criar.getTipoPokemon())
                .dataNascimento(criar.getDataNascimento())
                .build());
    }

    private PacienteRepository pacienteRepository;

    public Page<Paciente> buscarTodos(Pageable pageable) {
        return this.pacienteRepository.findAll(pageable);
    }

    public Page<Paciente> buscarTodos(Predicate filtroURI, Pageable pageable) {
        return this.pacienteRepository.findAll(filtroURI, pageable);
    }

    public Paciente atualizar(
            Long idPaciente,
            PacienteRepresentation.CriarOuAtualizar atualizar) {

        this.getPaciente(idPaciente);

        Paciente pacienteParaAtualizar = Paciente.builder()
                .idPaciente(idPaciente)
                .nomePaciente(atualizar.getNomePaciente())
                .generoPokemon(atualizar.getGeneroPokemon())
                .tipoPokemon(atualizar.getTipoPokemon())
                .dataNascimento(atualizar.getDataNascimento())
                .build();

        return this.pacienteRepository.save(pacienteParaAtualizar);

    }

    public Paciente buscarUmPaciente(Long idPaciente) {

        return this.getPaciente(idPaciente);

    }

    private Paciente getPaciente(Long idPaciente) {
        Optional<Paciente> pacienteAtual =
                this.pacienteRepository.findById(idPaciente);

        if (pacienteAtual.isPresent()) {
            return pacienteAtual.get();
        } else {
            throw new NotFoundException("Paciente não encontrado");
        }
    }
}



