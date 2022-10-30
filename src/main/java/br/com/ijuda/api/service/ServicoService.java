package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.ServicoDTO;
import br.com.ijuda.api.model.Servico;
import br.com.ijuda.api.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico atualizar(Long codigo, Servico servico){
        Servico servicoSalvo = findServicoByCodigo(codigo);

        BeanUtils.copyProperties(servico,servicoSalvo,"codigo");
        return servicoRepository.save(servicoSalvo);
    }

    private Servico findServicoByCodigo(Long codigo) {
        Servico servicoSalvo = servicoRepository.findById(codigo)
                .orElseThrow(()-> new EmptyResultDataAccessException(1));
        return servicoSalvo;
    }

    public List<ServicoDTO> findAll() {
        List<Servico> servicoList = servicoRepository.findAll();
        return servicoList.stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ServicoDTO save(Servico servico) {
        Servico servicoSalvo = servicoRepository.save(servico);
        return toDTO(servicoSalvo);
    }

    private ServicoDTO toDTO(Servico servico) {
        return ServicoDTO.builder()
                .id(servico.getId())
                .nome(servico.getNome())
                .valor(servico.getValor())
                .categoria(servico.getCategoria())
                .build();
    }
}



