package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.BuscaServicoPrestadorDTO;
import br.com.ijuda.api.controller.dto.ClienteDTO;
import br.com.ijuda.api.controller.dto.Paginator;
import br.com.ijuda.api.controller.dto.PrestadorServicoDTO;
import br.com.ijuda.api.controller.filter.BuscaServicoPrestadorFilter;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.model.PrestadorServico;
import br.com.ijuda.api.repository.PrestadorServicoNativeRepository;
import br.com.ijuda.api.repository.PrestadorServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadorServicoService {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @Autowired
    private PrestadorServicoNativeRepository prestadorServicoNativeRepository;

    public PrestadorServico atualizar(Long codigo, PrestadorServico prestadorServico) {
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);

        BeanUtils.copyProperties(prestadorServico, prestadorServicoSalvo, "codigo");
        return prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        PrestadorServico prestadorServicoSalvo = findPrestadorServicoByCodigo(codigo);
        prestadorServicoSalvo.setAtivo(ativo);
        prestadorServicoRepository.save(prestadorServicoSalvo);
    }

    private PrestadorServico findPrestadorServicoByCodigo(Long codigo) {
        PrestadorServico prestadorServicoSalvo = prestadorServicoRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return prestadorServicoSalvo;
    }

    public List<PrestadorServicoDTO> findAll() {
        List<PrestadorServico> prestadorServicoList = prestadorServicoRepository.findAll();
        return prestadorServicoList.stream().map(dto -> PrestadorServicoDTO.builder()
                .id(dto.getId())
                .usuario(dto.getUsuario())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .ativo(dto.getAtivo())
                .build()
        ).collect(Collectors.toList());
    }

    public Paginator<BuscaServicoPrestadorDTO> buscaPrestadorServicoByFilter(BuscaServicoPrestadorFilter filter, Pageable pageable) {
        Page<BuscaServicoPrestadorDTO> page = prestadorServicoNativeRepository.findByFilter(filter, pageable);
        List<BuscaServicoPrestadorDTO> resultado = page.getContent()
                .stream().map(r -> BuscaServicoPrestadorDTO.builder()
                        .prestadorServicoId(r.getPrestadorServicoId())
                        .prestadorServico(r.getPrestadorServico())
                        .servicoId(r.getServicoId())
                        .servico(r.getServico())
                        .categoriaId(r.getCategoriaId())
                        .categoria(r.getCategoria())
                        .imagem(r.getImagem())
                        .build()
                ).collect(Collectors.toList());
        return new Paginator<>(page, resultado);
    }
}