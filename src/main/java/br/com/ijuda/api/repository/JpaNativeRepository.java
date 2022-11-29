package br.com.ijuda.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaNativeRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    protected <T> Page<T> getPage(List<T> resultList, Pageable pageable, Long count) {
        return new PageImpl<>(resultList, pageable, count);
    }
}