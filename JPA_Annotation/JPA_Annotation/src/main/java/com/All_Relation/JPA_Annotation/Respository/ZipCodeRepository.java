package com.All_Relation.JPA_Annotation.Respository;

import com.All_Relation.JPA_Annotation.Model.ZipCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode,Long> {
}
