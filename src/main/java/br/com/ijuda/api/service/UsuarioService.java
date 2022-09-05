package br.com.ijuda.api.service;

import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.model.Usuario;
import br.com.ijuda.api.repository.ClienteRepository;
import br.com.ijuda.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
}



