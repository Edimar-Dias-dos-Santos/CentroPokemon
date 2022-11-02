package com.API.CentroPokemon.paciente;

import com.API.CentroPokemon.treinador.StatusTreinador;
import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepresentation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface PacienteRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O campo nome não pode ser vazio")
        private String nomePaciente;

        @NotNull(message = "O campo gênero não pode ser nulo")
        @NotEmpty(message = "O campo gênero não pode ser vazio")
        private GeneroPokemon generoPokemon;

        @NotNull(message = "O campo tipo não pode ser nulo")
        @NotEmpty(message = "O campo tipo não pode ser vazio")
        private TipoPokemon tipoPokemon;

        @NotNull(message = "O campo data de nascimento não pode ser nulo")
        @NotEmpty(message = "O campo data de nascimento não pode ser vazio")
        private Date dataNascimento;

        public static PacienteRepresentation.Detalhes from(Paciente paciente) {
            return PacienteRepresentation.Detalhes.builder()
                    .id(paciente.getIdPaciente())
                    .nomePaciente(paciente.getNomePaciente())
                    .generoPokemon(paciente.getGeneroPokemon())
                    .tipoPokemon(paciente.getTipoPokemon())
                    .dataNascimento(paciente.getDataNascimento())
                    .build();
        }
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private String nomePaciente;
        private GeneroPokemon generoPokemon;
        private TipoPokemon tipoPokemon;
        private Date dataNascimento;

        public static PacienteRepresentation.Detalhes from(Paciente paciente) {
            return PacienteRepresentation.Detalhes.builder()
                    .id(paciente.getIdPaciente())
                    .nomePaciente(paciente.getNomePaciente())
                    .generoPokemon(paciente.getGeneroPokemon())
                    .tipoPokemon(paciente.getTipoPokemon())
                    .dataNascimento(paciente.getDataNascimento())
                    .build();
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private String nomePaciente;
        private GeneroPokemon generoPokemon;
        private TipoPokemon tipoPokemon;
        private Date dataNascimento;

        private static PacienteRepresentation.Lista from(Paciente paciente) {
            return PacienteRepresentation.Lista.builder()
                    .id(paciente.getIdPaciente())
                    .nomePaciente(paciente.getNomePaciente())
                    .generoPokemon(paciente.getGeneroPokemon())
                    .tipoPokemon(paciente.getTipoPokemon())
                    .dataNascimento(paciente.getDataNascimento())
                    .build();
        }

        public static List<PacienteRepresentation.Lista> from(List<Paciente> pacienteList) {
            return pacienteList
                    .stream()
                    .map(PacienteRepresentation.Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
