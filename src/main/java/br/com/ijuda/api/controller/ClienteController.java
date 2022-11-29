package br.com.ijuda.api.controller;

import br.com.ijuda.api.controller.dto.ClienteDTO;
import br.com.ijuda.api.exceptionhandler.ClienteNaoEncontradoException;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.repository.ClienteRepository;
import br.com.ijuda.api.service.ClienteService;
import br.com.ijuda.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
        usuarioService.criptografar(cliente.getUsuario());
        usuarioService.adicionaImagem(cliente.getUsuario());
        ClienteDTO clienteSalvo = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{codigo}")
    public ClienteDTO buscarPeloCodigo(@PathVariable Long codigo) {
        Cliente cliente = clienteRepository.findById(codigo)
                .orElseThrow(ClienteNaoEncontradoException::new);
        return clienteService.toDTO(cliente);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
        this.clienteRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.atualizar(codigo,cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        clienteService.atualizarPropriedadeAtivo(codigo,ativo);
    }

}

