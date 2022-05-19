package ru.itService.service;

import org.springframework.stereotype.Service;
import ru.itService.model.MagicSquare;
import ru.itService.model.MagicSquareResult;
import ru.itService.persistence.MagicSquareResultRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagicSquareResultService {

    private final MagicSquareResultRepository repository;

    public MagicSquareResultService(MagicSquareResultRepository repository) {
        this.repository = repository;
    }

    public List<MagicSquareResult> findAll() {
        List<MagicSquareResult> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void create(MagicSquare magicSquare) {
        repository.save(Calculation.calculationMagicSquare(magicSquare));
    }

    public void createAll(List<MagicSquare> magicSquares) {
        for (var item : magicSquares) {
            repository.save(Calculation.calculationMagicSquare(item));
        }
    }

}
