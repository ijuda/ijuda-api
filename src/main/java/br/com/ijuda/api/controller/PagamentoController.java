package br.com.ijuda.api.controller;

import br.com.ijuda.api.controller.dto.PagamentoDTO;
import br.com.ijuda.api.controller.dto.PrestadorServicoDTO;
import br.com.ijuda.api.model.Pagamento;
import br.com.ijuda.api.model.SolicitacaoServico;
import br.com.ijuda.api.repository.PagamentoRepository;
import br.com.ijuda.api.repository.SolicitacaoServicoRepository;
import br.com.ijuda.api.service.PagamentoService;
import br.com.ijuda.api.service.SolicitacaoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> criar(@Valid @RequestBody Pagamento pagamento, HttpServletResponse response) {
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoSalvo);
    }

    @GetMapping("/pagamentos")
    public ResponseEntity<List<PagamentoDTO>> findAll(){
        return ResponseEntity.ok(pagamentoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pagamento> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(codigo);
        return pagamento.isPresent()? ResponseEntity.ok(pagamento.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.pagamentoRepository.deleteById(codigo);
    }

}

