package com.API.CentroPokemon.Treinador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "treinador")
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTreinador;

    @Column(name = "nome_treinador")
    private String nomeTreinador;

    @Column(name = "rg_treinador")
    private String rgTreinador;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "treinador", orphanRemoval = true)
    //List<Pokemon> pokemonList = new ArrayList<>();
}
