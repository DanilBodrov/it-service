package ru.itService.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itService.model.MagicSquare;

@Repository
public interface MagicSquareRepository extends CrudRepository<MagicSquare, Integer> {
}
