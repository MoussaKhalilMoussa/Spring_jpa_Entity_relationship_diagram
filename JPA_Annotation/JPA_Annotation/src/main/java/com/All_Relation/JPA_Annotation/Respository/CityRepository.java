package com.All_Relation.JPA_Annotation.Respository;

import com.All_Relation.JPA_Annotation.Model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
}
