package br.com.ijuda.api.service;

import br.com.ijuda.api.model.Categoria;
import br.com.ijuda.api.model.Cliente;
import br.com.ijuda.api.repository.CategoriaRepository;
import br.com.ijuda.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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

}



