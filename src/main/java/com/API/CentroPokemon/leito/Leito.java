package com.API.CentroPokemon.leito;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "leito")
public class Leito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeito;

    @Column(name = "numero_leito")
    private Long numeroLeito;

    @Column(name = "tipo_leito")
    private String tipoLeito;

    @Column(name = "status_leito")
    @Enumerated(value = EnumType.STRING)
    private StatusLeito statusLeito;

    @Column(name = "leito_ativo")
    @Enumerated(value = EnumType.STRING)
    private LeitoAtivo leitoAtivo;

    //id_leito OK
    //numero_leito OK
    //status_leito
    //tipo_leito OK
}
