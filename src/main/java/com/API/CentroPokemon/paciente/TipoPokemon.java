package com.API.CentroPokemon.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public enum TipoPokemon {
    AC("AÇO"),
    AG("ÁGUA"),
    DR("DRAGÃO"),
    El("ELÉTRICO"),
    FD("FADA"),
    FA("FANTASMA"),
    FO("FOGO"),
    GE("GELO"),
    IN("INSETO"),
    LU("LUTADOR"),
    NO("NORMAL"),
    PE("PEDRA"),
    PL("PLANTA"),
    PS("PSÍQUICO"),
    SO("SOMBRIO"),
    TE("TERRESTRE"),
    VE("VENENOSO"),
    VO("VOADOR");

    private String descricao;


}