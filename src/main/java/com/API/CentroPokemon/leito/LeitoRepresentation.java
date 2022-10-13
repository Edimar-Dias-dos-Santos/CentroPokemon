package com.API.CentroPokemon.leito;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface LeitoRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class CriarOuAtualizar {

        @NotNull(message = "O campo número não pode ser nulo")
        private long numeroLeito;

        @NotNull(message = "O campo tipo de leito não pode ser nulo")
        @NotEmpty
        private String tipoLeito;

        private StatusLeito statusLeito;

        public static Detalhes from(Leito leito) {
            return Detalhes.builder()
                    .id(leito.getIdLeito())
                    .numeroLeito(leito.getNumeroLeito())
                    .tipoLeito(leito.getTipoLeito())
                    .statusLeito(leito.getStatusLeito())
                    .build();
        }
    }

    @Data
    @Builder
    class Detalhes {
        private Long id;
        private Long numeroLeito;
        private String tipoLeito;
        private StatusLeito statusLeito;

        public static LeitoRepresentation.Detalhes from(Leito leito) {
            return Detalhes.builder()
                    .id(leito.getIdLeito())
                    .numeroLeito(leito.getNumeroLeito())
                    .tipoLeito(leito.getTipoLeito())
                    .statusLeito(leito.getStatusLeito())
                    .build();
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class Lista {
        private Long id;
        private Long numeroLeito;
        private String tipoLeito;
        private StatusLeito statusLeito;

        private static LeitoRepresentation.Lista from(Leito leito) {
            return Lista.builder()
                    .id(leito.getIdLeito())
                    .numeroLeito(leito.getNumeroLeito())
                    .tipoLeito(leito.getTipoLeito())
                    .statusLeito(leito.getStatusLeito())
                    .build();

        }

        public static List<LeitoRepresentation.Lista> from(List<Leito> leitoList) {
            return leitoList
                    .stream()
                    .map(LeitoRepresentation.Lista::from)
                    .collect(Collectors.toList());
        }
    }
}
