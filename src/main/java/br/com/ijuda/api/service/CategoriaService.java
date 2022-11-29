package br.com.ijuda.api.service;

import br.com.ijuda.api.controller.dto.CategoriaDTO;
import br.com.ijuda.api.model.Categoria;
import br.com.ijuda.api.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria atualizar(Long codigo, Categoria categoria){
        Categoria categoriaSalvo = findCategoriaByCodigo(codigo);

        BeanUtils.copyProperties(categoria,categoriaSalvo,"codigo");
        return categoriaRepository.save(categoriaSalvo);
    }

    private Categoria findCategoriaByCodigo(Long codigo) {
        Categoria categoriaSalva = categoriaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return categoriaSalva;
    }

    public List<CategoriaDTO> findAll() {
        List<Categoria> categoriaList = categoriaRepository.findAll();
        return categoriaList.stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO save(Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return toDTO(categoriaSalva);
    }

    private CategoriaDTO toDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }
}



