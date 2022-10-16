package com.API.CentroPokemon.prontuario;

import com.API.CentroPokemon.treinador.Treinador;
import com.API.CentroPokemon.treinador.TreinadorRepresentation;
import com.API.CentroPokemon.treinador.TreinadorService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/prontuario")
@CrossOrigin("*")
@AllArgsConstructor
public class ProntuarioController {
    private ProntuarioService prontuarioService;

    @PostMapping("/")
    public ResponseEntity<ProntuarioRepresentation.Detalhes> createProntuario(
            @RequestBody @Valid ProntuarioRepresentation.CriarOuAtualizar criar){

        Prontuario prontuario = this.prontuarioService.criarProntuario(criar);

        ProntuarioRepresentation.Detalhes detalhes =
                ProntuarioRepresentation.Detalhes.from(prontuario);

        return ResponseEntity.ok(detalhes);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProntuarioRepresentation.Lista>> buscarProntuario(
            @QuerydslPredicate(root = Prontuario.class) Predicate filtroURI,
            @RequestParam(name="tamanhoPagina", defaultValue = "30") int tamanhoPagina,
            @RequestParam(name = "paginaSelecionada", defaultValue = "0") int paginaSelecionada) {


        Pageable pageable = PageRequest.of(paginaSelecionada, tamanhoPagina);

        Page<Prontuario> prontuarioList = Objects.isNull(filtroURI) ?
                this.prontuarioService.buscarTodos(pageable) :
                this.prontuarioService.buscarTodos(filtroURI, pageable);

        List<ProntuarioRepresentation.Lista> listaFinal =
                ProntuarioRepresentation.Lista.from(prontuarioList.getContent());

        return ResponseEntity.ok(listaFinal);
    }


    @PutMapping("/{idProntuario}")
    public ResponseEntity<ProntuarioRepresentation.Detalhes> atualizarProntuario(
            @PathVariable Long idProntuario,
            @RequestBody ProntuarioRepresentation.CriarOuAtualizar atualizar) {

        Prontuario prontuarioAtualizado =
                this.prontuarioService.atualizar(idProntuario, atualizar);

        ProntuarioRepresentation.Detalhes detalhes =
                ProntuarioRepresentation.Detalhes
                        .from(prontuarioAtualizado);

        return ResponseEntity.ok(detalhes);
    }

    @GetMapping("/{idProntuario}")
    public ResponseEntity<ProntuarioRepresentation.Detalhes> buscarUmProntuario(
            @PathVariable Long idProntuario) {

        Prontuario prontuario = this.prontuarioService.buscarUmProntuario(idProntuario);

        ProntuarioRepresentation.Detalhes detalhes =
                ProntuarioRepresentation.Detalhes
                        .from(prontuario);

        return ResponseEntity.ok(detalhes);
    }
}
