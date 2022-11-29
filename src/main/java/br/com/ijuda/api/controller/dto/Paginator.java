package br.com.ijuda.api.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Paginator<T> {
    private List<T> content;

    private int number;

    private int size;

    private long totalElements;

    private long totalPages;

    private boolean firstPage;

    private boolean lastPage;

    private boolean empty;

    public Paginator(Page page, List<T> content) {
        this.content = content;
        this.number = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.firstPage = page.isFirst();
        this.lastPage = page.isLast();
        this.empty = page.isEmpty();
    }
}
