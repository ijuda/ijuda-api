package br.com.ijuda.api.repository;

import br.com.ijuda.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query(value = "SELECT s FROM Servico s WHERE s.categoria = :categoriaId")
    List<Servico> findByCategoria(@Param("categoriaId") String categoriaId);
}