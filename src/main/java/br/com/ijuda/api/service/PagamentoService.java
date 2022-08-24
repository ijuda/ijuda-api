package br.com.ijuda.api.service;

import br.com.ijuda.api.model.Pagamento;
import br.com.ijuda.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    private Pagamento findPagamentoByCodigo(Long codigo) {
        Pagamento pagamentoSalvo = pagamentoRepository.findById(codigo)
                .orElseThrow(()-> new EmptyResultDataAccessException(1));
        return pagamentoSalvo;
    }

}



