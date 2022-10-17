package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.PagamentoDTO;
import br.com.ijuda.api.model.Pagamento;
import br.com.ijuda.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    private Pagamento findPagamentoByCodigo(Long codigo) {
        Pagamento pagamentoSalvo = pagamentoRepository.findById(codigo)
                .orElseThrow(()-> new EmptyResultDataAccessException(1));
        return pagamentoSalvo;
    }

    public List<PagamentoDTO> findAll() {
        List<Pagamento> pagamentoList = pagamentoRepository.findAll();
        return pagamentoList.stream().map(dto -> PagamentoDTO.builder()
                .id(dto.getId())
                .dataPagamento(dto.getDataPagamento())
                .cliente(dto.getCliente())
                .valor(dto.getValor())
                .build()
        ).collect(Collectors.toList());
    }

}



