package br.com.ijuda.api.repository;

import br.com.ijuda.api.model.Pagamento;
import br.com.ijuda.api.model.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}