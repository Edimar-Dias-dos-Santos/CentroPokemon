package com.API.CentroPokemon.prontuario;

import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepresentation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface ProntuarioRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo descrição não pode ser nulo")
        @NotEmpty(message = "O campo descrição não pode ser vazio")
        private String descricaoProntuario;

        @NotNull(message = "O campo nome do médico não pode ser nulo")
        @NotEmpty(message = "O campo nome do médico não pode ser vazio")
        private String nomeMedico;

        public static ProntuarioRepresentation.Detalhes from(Prontuario prontuario) {
            return Detalhes.builder()
                    .id(prontuario.getIdProntuario())
                    .descricaoProntuario(prontuario.getDescricaoProntuario())
                    .nomeMedico(prontuario.getNomeMedico())
                    .build();
        }
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private String descricaoProntuario;
        private String nomeMedico;

        public static ProntuarioRepresentation.Detalhes from(Prontuario prontuario) {
            return Detalhes.builder()
                    .id(prontuario.getIdProntuario())
                    .descricaoProntuario(prontuario.getDescricaoProntuario())
                    .nomeMedico(prontuario.getNomeMedico())
                    .build();
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private String descricaoProntuario;
        private String nomeMedico;

        private static ProntuarioRepresentation.Lista from(Prontuario prontuario) {
            return ProntuarioRepresentation.Lista.builder()
                    .id(prontuario.getIdProntuario())
                    .descricaoProntuario(prontuario.getDescricaoProntuario())
                    .nomeMedico(prontuario.getNomeMedico())
                    .build();
        }

        public static List<ProntuarioRepresentation.Lista> from(List<Prontuario> prontuarioList) {
            return prontuarioList
                    .stream()
                    .map(ProntuarioRepresentation.Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
