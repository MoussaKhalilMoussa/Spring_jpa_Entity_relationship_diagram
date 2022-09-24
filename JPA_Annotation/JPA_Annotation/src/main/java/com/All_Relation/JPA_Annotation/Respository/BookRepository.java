package com.All_Relation.JPA_Annotation.Respository;

import com.All_Relation.JPA_Annotation.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
