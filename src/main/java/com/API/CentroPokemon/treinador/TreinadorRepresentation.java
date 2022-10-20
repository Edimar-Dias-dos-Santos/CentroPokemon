package com.API.CentroPokemon.treinador;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface TreinadorRepresentation {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O campo nome não pode ser vazio")
        private String nomeTreinador;

        @NotNull(message = "O campo rg não pode ser nulo")
        @NotEmpty(message = "O campo rg não pode ser vazio")
        private String rgTreinador;

        private StatusTreinador statusTreinador;

        public static Detalhes from(Treinador treinador) {
            return Detalhes.builder()
                    .id(treinador.getIdTreinador())
                    .nomeTreinador(treinador.getNomeTreinador())
                    .rgTreinador(treinador.getRgTreinador())
                    .statusTreinador(treinador.getStatusTreinador())
                    .build();
        }
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private String nomeTreinador;
        private String rgTreinador;
        private StatusTreinador statusTreinador;

        public static Detalhes from(Treinador treinador) {
            return Detalhes.builder()
                    .id(treinador.getIdTreinador())
                    .nomeTreinador(treinador.getNomeTreinador())
                    .rgTreinador(treinador.getRgTreinador())
                    .statusTreinador(treinador.getStatusTreinador())
                    .build();
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private String nomeTreinador;
        private String rgTreinador;
        private StatusTreinador statusTreinador;
        //private String nomeCompleto;

        private static Lista from(Treinador treinador) {
            //return treinador.getPokemonList().isEmpty() ?
           return Lista.builder()
                    .id(treinador.getIdTreinador())
                    .nomeTreinador(treinador.getNomeTreinador())
                    .rgTreinador(treinador.getRgTreinador())
                    .statusTreinador(treinador.getStatusTreinador())
//                    .nomeCompleto(
//                            String.format("%s %s", treinador.getNomeTreinador(), treinador.getRgTreinador())
//                    )
                    .build();

        }

        public static List<Lista> from(List<Treinador> treinadorList) {
            return treinadorList
                    .stream()
                    .map(Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
