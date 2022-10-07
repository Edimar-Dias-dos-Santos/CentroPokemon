package com.API.CentroPokemon.leito;

import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface LeitoRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo número não pode ser nulo")
        @NotEmpty
        private Long numeroLeito;

        @NotNull(message = "O campo tipo leito não pode ser nulo")
        @NotEmpty
        private String tipoLeito;


    }
}
