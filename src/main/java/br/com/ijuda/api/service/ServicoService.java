package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.PagamentoDTO;
import br.com.ijuda.api.controller.dto.ServicoDTO;
import br.com.ijuda.api.model.Pagamento;
import br.com.ijuda.api.model.Servico;
import br.com.ijuda.api.model.SolicitacaoServico;
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
        return servicoList.stream().map(dto -> ServicoDTO.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .valor(dto.getValor())
                .categoria(dto.getCategoria())
                .build()
        ).collect(Collectors.toList());
    }
}



