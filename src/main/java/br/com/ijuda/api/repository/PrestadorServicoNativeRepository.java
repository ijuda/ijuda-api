package br.com.ijuda.api.repository;

import br.com.ijuda.api.controller.dto.BuscaServicoPrestadorDTO;
import br.com.ijuda.api.controller.filter.BuscaServicoPrestadorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PrestadorServicoNativeRepository extends JpaNativeRepository {

    public Page<BuscaServicoPrestadorDTO> findByFilter(BuscaServicoPrestadorFilter filter, Pageable pageable) {

        StringBuilder sql = new StringBuilder();
        getSelect(sql);
        getFromJoin(sql);
        getRestricoes(sql, filter);
        Query nativeQuery = entityManager.createNativeQuery(sql.toString(), Tuple.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());
        addParameter(filter, nativeQuery);
        List<Tuple> resultList = nativeQuery.getResultList();

        List<BuscaServicoPrestadorDTO> detalhes = transform(resultList);

        return getPage(detalhes, pageable, getCount(filter));
    }

    private void getSelect(StringBuilder sql) {
        sql.append(" SELECT ps_us.id as prestadorServicoId, ");
        sql.append(" ps_us.nome as prestadorServico, ");
        sql.append(" s.id as servicoId, ");
        sql.append(" s.nome as servico, ");
        sql.append(" serv_cat.id as categoriaId, ");
        sql.append(" serv_cat.nome as categoria, ");
        sql.append(" ps_us.imagem as imagem ");
    }

    private void getFromJoin(StringBuilder sql) {
        sql.append(" FROM servico_prestadores_servicos sps ");
        sql.append(" INNER JOIN servico s ON sps.servico_id = s.id ");
        sql.append(" INNER JOIN prestador_servico ps ON sps.prestador_servico_id = ps.id ");
        sql.append(" INNER JOIN (SELECT ps.id, ");
        sql.append(" us.nome, us.imagem ");
        sql.append(" FROM prestador_servico ps ");
        sql.append(" INNER JOIN usuario us ");
        sql.append(" ON ps.id = us.id) ");
        sql.append(" AS ps_us ON ");
        sql.append(" sps.prestador_servico_id = ps_us.id ");
        sql.append(" INNER JOIN (SELECT serv.id, cat.nome ");
        sql.append(" from servico serv ");
        sql.append(" INNER JOIN categoria cat ON serv.id = cat.id ) ");
        sql.append(" AS serv_cat ON sps.servico_id = serv_cat.id ");
    }

    private void getRestricoes(StringBuilder sql, BuscaServicoPrestadorFilter filter) {
        sql.append(" where ps.ativo is true ");

        if (Objects.nonNull(filter.getServicos()) && !filter.getServicos().isEmpty()) {
            sql.append(" and s.id in (:servicos) ");
        }

        if (Objects.nonNull(filter.getCategorias()) && !filter.getCategorias().isEmpty()) {
            sql.append(" and serv_cat.id in (:categorias) ");
        }
    }

    private void addParameter(BuscaServicoPrestadorFilter filter, Query nativeQuery) {
        if (Objects.nonNull(filter.getServicos()) && !filter.getServicos().isEmpty()) {
            nativeQuery.setParameter("servicos", filter.getServicos());
        }

        if (Objects.nonNull(filter.getCategorias()) && !filter.getCategorias().isEmpty()) {
            nativeQuery.setParameter("categorias", filter.getCategorias());
        }
    }

    private List<BuscaServicoPrestadorDTO> transform(List<Tuple> resultList) {
        return resultList.stream()
                .map(BuscaServicoPrestadorDTO::tupleToDTO)
                .collect(Collectors.toList());
    }

    private Long getCount(BuscaServicoPrestadorFilter filter) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(*) from ( ");
        getSelect(sql);
        getFromJoin(sql);
        getRestricoes(sql, filter);
        sql.append(" ) as total ");
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        addParameter(filter, nativeQuery);
        return ((Number) nativeQuery.getSingleResult()).longValue();
    }


}
