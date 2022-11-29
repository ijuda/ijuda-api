package br.com.ijuda.api.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;

import br.com.ijuda.api.controller.dto.BuscaServicoPrestadorDTO;
import br.com.ijuda.api.controller.dto.Paginator;
import br.com.ijuda.api.controller.dto.PrestadorServicoDTO;
import br.com.ijuda.api.controller.filter.BuscaServicoPrestadorFilter;
import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.repository.PrestadorServicoRepository;
import br.com.ijuda.api.service.PrestadorServicoService;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestadorservico")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @Autowired
    private PrestadorServicoService prestadorServicoService;

    @PostMapping
    public ResponseEntity<PrestadorServicoDTO> criar(@Valid @RequestBody PrestadorServico prestadorServico, HttpServletResponse response) {
        PrestadorServicoDTO prestadorServicoSalvo = prestadorServicoService.save(prestadorServico);
        prestadorServicoService.adicionaImagem(prestadorServicoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(prestadorServicoSalvo);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<PrestadorServicoDTO>> criarList(@Valid @RequestBody List<PrestadorServico>  prestadorServico) {
        List<PrestadorServicoDTO> prestadorServicoSalvo = prestadorServicoService.save2(prestadorServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(prestadorServicoSalvo);
    }

    @Operation(summary = "Lista todos",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Requisição mal formatada.",
                            content = @Content(schema = @Schema(ref = "Problema"))
                    )
            })
    @GetMapping("/prestadoresServico")
    public ResponseEntity<List<PrestadorServicoDTO>> findAll(){
        return ResponseEntity.ok(prestadorServicoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PrestadorServico> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<PrestadorServico> prestadorServico = prestadorServicoRepository.findById(codigo);
        return prestadorServico.isPresent()? ResponseEntity.ok(prestadorServico.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.prestadorServicoRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PrestadorServico> atualizar(@PathVariable Long codigo, @Valid @RequestBody PrestadorServico prestadorServico) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoService.atualizar(codigo,prestadorServico);
        return ResponseEntity.ok(prestadorServicoSalvo);
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        prestadorServicoService.atualizarPropriedadeAtivo(codigo,ativo);
    }

    @GetMapping(value = "/busca")
    public ResponseEntity<Paginator<BuscaServicoPrestadorDTO>> buscarPrestadorByFilter(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                                                                                      @Valid BuscaServicoPrestadorFilter filter) {
        return ResponseEntity.ok(prestadorServicoService.buscaPrestadorServicoByFilter(filter, pageable));
    }
}

