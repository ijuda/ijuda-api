package br.com.ijuda.api.service;

import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.repository.PrestadorServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PrestadorServicoService {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    public PrestadorServico atualizar(Long codigo, PrestadorServico prestadorServico){
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);

        BeanUtils.copyProperties(prestadorServico,prestadorServicoSalvo,"codigo");
        return prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo){
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);
        prestadorServicoSalvo.setAtivo(ativo);
        prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    private PrestadorServico findPrestadorServicoByCodigo(Long codigo) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return prestadorServicoSalvo;
    }

}



