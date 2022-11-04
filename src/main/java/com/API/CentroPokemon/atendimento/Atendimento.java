package com.API.CentroPokemon.atendimento;

import com.API.CentroPokemon.leito.Leito;
import com.API.CentroPokemon.paciente.Paciente;
import com.API.CentroPokemon.paciente.TipoPokemon;
import com.API.CentroPokemon.prontuario.Prontuario;
import com.API.CentroPokemon.treinador.StatusTreinador;
import com.API.CentroPokemon.treinador.Treinador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtendimento;

    @Column(name = "data_entrada")
    private Date dataEntrada;

    @Column(name = "data_saida")
    private Date dataSaida;

    @Column(name = "tipo_atendimento")
    private TipoAtendimento tipoAtendimento;

    @Column(name = "custo_atendimento")
    private Number custoAtendimento;

    @Column(name = "status_atendimento")
    @Enumerated(value = EnumType.STRING)
    private StatusTreinador statusAtendimento;

    @ManyToOne
    private Leito leito;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Prontuario prontuario;
}
