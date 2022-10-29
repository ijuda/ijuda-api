package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.ClienteDTO;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO save(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return toDTO(clienteSalvo);
    }

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

    public List<ClienteDTO> findAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO toDTO(Cliente cliente){
        var clienteDTO = new ClienteDTO();
        clienteDTO.setAtivo(cliente.getAtivo());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setEndereco(cliente.getEndereco());
        clienteDTO.setId(cliente.getId());
        clienteDTO.setUsuario(cliente.getUsuario());
        clienteDTO.setTelefone(cliente.getTelefone());
        return clienteDTO;
    }

}



