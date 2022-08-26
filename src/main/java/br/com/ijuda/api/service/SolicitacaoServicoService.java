package br.com.ijuda.api.service;

import br.com.ijuda.api.model.SolicitacaoServico;
import br.com.ijuda.api.repository.SolicitacaoServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoServicoService {

    @Autowired
    private SolicitacaoServicoRepository solicitacaoServicoRepository;

    public SolicitacaoServico atualizar(Long codigo, SolicitacaoServico solicitacaoServico){
        SolicitacaoServico solicitacaoServicoSalva = findSolicitacaoServicoByCodigo(codigo);

        BeanUtils.copyProperties(solicitacaoServico,solicitacaoServicoSalva,"codigo");
        return solicitacaoServicoRepository.save(solicitacaoServicoSalva);
    }

    private SolicitacaoServico findSolicitacaoServicoByCodigo(Long codigo) {
        SolicitacaoServico solicitacaoServicoSalva = solicitacaoServicoRepository.findById(codigo)
                .orElseThrow(()-> new EmptyResultDataAccessException(1));
        return solicitacaoServicoSalva;
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo){
        SolicitacaoServico solicitacaoServicoSalva = findSolicitacaoServicoByCodigo(codigo);
        solicitacaoServicoSalva.setAtivo(ativo);
        solicitacaoServicoRepository.save(solicitacaoServicoSalva);
    }

}



