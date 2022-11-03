package com.API.CentroPokemon.atendimento;

import com.API.CentroPokemon.paciente.GeneroPokemon;
import com.API.CentroPokemon.paciente.Paciente;
import com.API.CentroPokemon.paciente.PacienteRepresentation;
import com.API.CentroPokemon.paciente.TipoPokemon;
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

public interface AtendimentoRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo data de entrada não pode ser nulo")
        @NotEmpty(message = "O campo data de entrada não pode ser vazio")
        private Date dataEntrada;

        @NotNull(message = "O campo data de saída não pode ser nulo")
        @NotEmpty(message = "O campo data de saída não pode ser vazio")
        private Date dataSaida;

        @NotNull(message = "O campo tipo não pode ser nulo")
        @NotEmpty(message = "O campo tipo não pode ser vazio")
        private TipoAtendimento tipoAtendimento;

        @NotNull(message = "O campo custo não pode ser nulo")
        @NotEmpty(message = "O campo custo não pode ser vazio")
        private Number custoAtendimento;

        public static Detalhes from(Atendimento atendimento) {
            return Detalhes.builder()
                    .idAtendimento(atendimento.getIdAtendimento())
                    .dataEntrada(atendimento.getDataEntrada())
                    .dataSaida(atendimento.getDataSaida())
                    .tipoAtendimento(atendimento.getTipoAtendimento())
                    .custoAtendimento(atendimento.getCustoAtendimento())
                    .build();
        }
    }

    @Data
    @Builder
    class Detalhes {
        private Long idAtendimento;
        private Date dataEntrada;
        private Date dataSaida;
        private TipoAtendimento tipoAtendimento;
        private Number custoAtendimento;

        public static Detalhes from(Atendimento atendimento) {
            return Detalhes.builder()
                    .idAtendimento(atendimento.getIdAtendimento())
                    .dataEntrada(atendimento.getDataEntrada())
                    .dataSaida(atendimento.getDataSaida())
                    .tipoAtendimento(atendimento.getTipoAtendimento())
                    .custoAtendimento(atendimento.getCustoAtendimento())
                    .build();
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long idAtendimento;
        private Date dataEntrada;
        private Date dataSaida;
        private TipoAtendimento tipoAtendimento;
        private Number custoAtendimento;

        private static Lista from(Atendimento atendimento) {
            return Lista.builder()
                    .idAtendimento(atendimento.getIdAtendimento())
                    .dataEntrada(atendimento.getDataEntrada())
                    .dataSaida(atendimento.getDataSaida())
                    .tipoAtendimento(atendimento.getTipoAtendimento())
                    .custoAtendimento(atendimento.getCustoAtendimento())
                    .build();
        }

        public static List<Lista> from(List<Atendimento> atendimentoList) {
            return atendimentoList
                    .stream()
                    .map(Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
