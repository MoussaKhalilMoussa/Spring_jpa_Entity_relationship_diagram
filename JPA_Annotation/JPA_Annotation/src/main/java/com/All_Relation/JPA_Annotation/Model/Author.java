package com.All_Relation.JPA_Annotation.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zipcode_id")
    private ZipCode zipcode;
    @ManyToMany(mappedBy ="category" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Author(String name, ZipCode zipcode, List<Book> books) {
        this.name = name;
        this.zipcode = zipcode;
        this.books = books;
    }

    public void addBook (Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }









}
