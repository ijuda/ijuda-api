package br.com.ijuda.api.service;

import br.com.ijuda.api.model.Servico;
import br.com.ijuda.api.model.SolicitacaoServico;
import br.com.ijuda.api.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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

}



