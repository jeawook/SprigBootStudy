package jpabook.jpashop.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateItemDto {
    private Long id;
    private String name;
    private int price;
    private String author;
    private String isbn;

    public UpdateItemDto(Long id, String name, int price, String author, String isbn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
    }
}
