package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.ClienteDTO;
import br.com.ijuda.api.controller.dto.UsuarioDTO;
import br.com.ijuda.api.exceptionhandler.UserNotFoundException;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.model.Usuario;
import br.com.ijuda.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criptografar(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = usuario.getSenha();
        String senhaCrypto = encoder.encode(senha);
        usuario.setSenha(senhaCrypto);
        return usuario;
    }

    public UsuarioDTO findByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail()).build();
    }

    public void adicionaImagem(Cliente cliente) {
        if (cliente.getUsuario().getNome() != null ){
            String nome = cliente.getUsuario().getNome();
            String string = nome;

            String[] splitted= string.split(" ");

            String splitted1= splitted[0];

            String splitted2 = splitted[1];

            String imagem ="https://ui-avatars.com/api/?name="+ splitted1 + "+"+ splitted2;
            cliente.getUsuario().setImagem(imagem);
        }
    }
}



