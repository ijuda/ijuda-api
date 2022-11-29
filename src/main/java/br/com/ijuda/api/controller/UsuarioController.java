package br.com.ijuda.api.controller;

import br.com.ijuda.api.controller.dto.UsuarioDTO;
import br.com.ijuda.api.model.Usuario;
import br.com.ijuda.api.repository.UsuarioRepository;
import br.com.ijuda.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
        usuarioService.adicionaImagem(usuario);
        Usuario usuarioCripto = usuarioService.criptografar(usuario);
        UsuarioDTO usuarioSalvoDto = usuarioService.save(usuarioCripto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvoDto);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Usuario> usuario = usuarioRepository.findById(codigo);
        return usuario.isPresent()? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email")
    public ResponseEntity<UsuarioDTO> findByEmail(@RequestParam(name ="email" ) String email) {
        Optional<UsuarioDTO> usuarioDTO = Optional.ofNullable(usuarioService.findByEmail(email));
        return usuarioDTO.isPresent()? ResponseEntity.ok(usuarioDTO.get()) : ResponseEntity.notFound().build();
    }
}

