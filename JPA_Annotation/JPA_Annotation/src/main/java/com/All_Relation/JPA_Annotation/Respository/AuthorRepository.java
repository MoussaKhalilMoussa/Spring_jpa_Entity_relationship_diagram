package com.All_Relation.JPA_Annotation.Respository;

import com.All_Relation.JPA_Annotation.Model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
