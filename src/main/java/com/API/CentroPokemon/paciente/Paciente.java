package com.API.CentroPokemon.paciente;

import com.API.CentroPokemon.paciente.GeneroPokemon;
import com.API.CentroPokemon.paciente.TipoPokemon;
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
@Entity(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(name = "nome_paciente")
    private String nomePaciente;

    @Column(name = "genero_pokemon")
    private GeneroPokemon generoPokemon;

    @Column(name = "tipo_pokemon")
    private TipoPokemon tipoPokemon;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @ManyToOne
    private Treinador treinador;
}