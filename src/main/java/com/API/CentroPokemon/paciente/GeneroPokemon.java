package com.API.CentroPokemon.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GeneroPokemon {
    M("MASCULINo"),
    F("FEMININO");

    private String descricao;


}
