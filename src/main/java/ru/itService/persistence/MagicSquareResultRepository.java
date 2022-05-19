package ru.itService.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itService.model.MagicSquareResult;

@Repository
public interface MagicSquareResultRepository extends CrudRepository<MagicSquareResult, Integer> {

}
