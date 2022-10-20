package com.API.CentroPokemon.treinador;

import com.API.CentroPokemon.leito.StatusLeito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "status_treinador")
    @Enumerated(value = EnumType.STRING)
    private StatusTreinador statusTreinador;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "treinador", orphanRemoval = true)
    //List<Pokemon> pokemonList = new ArrayList<>();
}
