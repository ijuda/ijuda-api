package br.com.ijuda.api.service;

import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente atualizar(Long codigo,Cliente cliente){
        Cliente clienteSalvo = findClienteByCodigo(codigo);

        BeanUtils.copyProperties(cliente,clienteSalvo,"codigo");
        return clienteRepository.save(clienteSalvo);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo){
        Cliente clienteSalvo = findClienteByCodigo(codigo);
        clienteSalvo.setAtivo(ativo);
        clienteRepository.save(clienteSalvo);
    }

    private Cliente findClienteByCodigo(Long codigo) {
        Cliente clienteSalvo = clienteRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return clienteSalvo;
    }

}



