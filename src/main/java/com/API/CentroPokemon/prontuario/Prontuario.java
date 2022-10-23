package com.API.CentroPokemon.prontuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProntuario;

    @Column(name = "desc_prontuario")
    private String descricaoProntuario;

    @Column(name = "nm_medico")
    private String nomeMedico;

    //@OneToOne(fetch = FetchType.LAZY, mappedBy = "prontuario", orphanRemoval = true)
    //List<Atendimento> atendimentoList = new ArrayList<>();
}
