package br.com.ijuda.api.controller;

import br.com.ijuda.api.controller.dto.ServicoDTO;
import br.com.ijuda.api.model.Servico;
import br.com.ijuda.api.repository.ServicoRepository;
import br.com.ijuda.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoDTO> criar(@Valid @RequestBody Servico servico, HttpServletResponse response) {
        ServicoDTO servicoSalvo = servicoService.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoSalvo);
    }

    @GetMapping("/servicos")
    public ResponseEntity<List<ServicoDTO>> findAll(){
        return ResponseEntity.ok(servicoService.findAll());
    }

    @GetMapping("/por-categoria")
    public ResponseEntity<List<ServicoDTO>> listaPorCategoria(@RequestParam(name = "categoriaId") String categoria){
        return ResponseEntity.ok(servicoService.findForCategory(categoria));
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Servico> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Servico> servico = servicoRepository.findById(codigo);
        return servico.isPresent()? ResponseEntity.ok(servico.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.servicoRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long codigo, @Valid @RequestBody Servico servico) {
        Servico servicoSalvo = servicoService.atualizar(codigo,servico);
        return ResponseEntity.ok(servicoSalvo);
    }
}

