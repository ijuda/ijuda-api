package br.com.ijuda.api.repository;

import br.com.ijuda.api.model.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Long> {

}