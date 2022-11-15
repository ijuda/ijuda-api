package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.BuscaServicoPrestadorDTO;
import br.com.ijuda.api.controller.dto.Paginator;
import br.com.ijuda.api.controller.dto.PrestadorServicoDTO;
import br.com.ijuda.api.controller.filter.BuscaServicoPrestadorFilter;
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
        return prestadorServicoList.stream().map(this::toDTO)
                .collect(Collectors.toList());
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

    public void adicionaImagem(PrestadorServicoDTO prestadorServicoSalvo) {
        if (prestadorServicoSalvo.getUsuario().getNome() != null ){
            String nome = prestadorServicoSalvo.getUsuario().getNome();
            String string = nome;

            String[] splitted= string.split(" ");

            String splitted1= splitted[0];

            String splitted2 = splitted[1];

            String imagem ="https://ui-avatars.com/api/?name="+ splitted1 + "+"+ splitted2;
            prestadorServicoSalvo.getUsuario().setImagem(imagem);
        }
    }

    public PrestadorServicoDTO save(PrestadorServico prestadorServico) {
        PrestadorServico prestadorSalvo = prestadorServicoRepository.save(prestadorServico);
        return toDTO(prestadorSalvo);
    }

    private PrestadorServicoDTO toDTO(PrestadorServico prestadorSalvo) {
        return PrestadorServicoDTO.builder()
                .id(prestadorSalvo.getId())
                .telefone(prestadorSalvo.getTelefone())
                .cpf(prestadorSalvo.getCpf())
                .endereco(prestadorSalvo.getEndereco())
                .ativo(prestadorSalvo.getAtivo())
                .usuario(prestadorSalvo.getUsuario())
                .servicos(prestadorSalvo.getServicos())
                .build();
    }
}