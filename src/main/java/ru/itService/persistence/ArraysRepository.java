package ru.itService.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itService.model.ArrayStrings;

import java.util.List;

@Repository
public interface ArraysRepository extends CrudRepository<ArrayStrings, Integer> {

    @Query("select ar from ArrayStrings ar where ar.count = :count")
    List<ArrayStrings> findByCount(@Param("count") int count);

}
