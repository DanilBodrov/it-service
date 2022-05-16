package ru.itService.service;

import org.springframework.stereotype.Service;
import ru.itService.model.ArrayStrings;
import ru.itService.model.MagicSquare;
import ru.itService.persistence.MagicSquareRepository;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
//import ru.itService.persistence.MagicSquareRepository;

@Service
public class MagicSquareService {

    private final MagicSquareRepository repository;

    public MagicSquareService(MagicSquareRepository repository) {
        this.repository = repository;
    }

    public void create(MagicSquare magicSquare) {
        repository.save(magicSquare);
    }

    public boolean validateMagicSquare(MagicSquare magicSquare) {
        boolean result = true;
        Set<Integer> set = new HashSet<>();
        set.add(magicSquare.getZeroZero());
        set.add(magicSquare.getZeroOne());
        set.add(magicSquare.getZeroTwo());
        set.add(magicSquare.getOneZero());
        set.add(magicSquare.getOneOne());
        set.add(magicSquare.getOneTwo());
        set.add(magicSquare.getTwoZero());
        set.add(magicSquare.getTwoOne());
        set.add(magicSquare.getTwoTwo());
        if (set.size() == 9) {
            result = false;
        }
        return result;
    }

    public void exportInTxt(MagicSquare magicSquare) {
        try(PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("exportSquareFromServer.txt", true)))) {
            out.println(System.lineSeparator());
            out.println("ЭКСПОРТ С СЕРВЕРА:");
            out.println("Row_1: " + magicSquare.getZeroZero() + " " + magicSquare.getZeroOne() + " " + magicSquare.getZeroTwo());
            out.println("Row_2: " + magicSquare.getOneZero() + " " + magicSquare.getOneOne() + " " + magicSquare.getOneTwo());
            out.println("Row_3: " + magicSquare.getTwoZero() + " " + magicSquare.getTwoOne() + " " + magicSquare.getTwoTwo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void magicCalculate(MagicSquare magicSquare) {
        System.out.println("========");
        System.out.print(magicSquare.getZeroZero());
        System.out.print(magicSquare.getZeroOne());
        System.out.print(magicSquare.getZeroTwo());
        System.out.println();
        System.out.print(magicSquare.getOneZero());
        System.out.print(magicSquare.getOneOne());
        System.out.print(magicSquare.getOneTwo());
        System.out.println();
        System.out.print(magicSquare.getTwoZero());
        System.out.print(magicSquare.getTwoOne());
        System.out.print(magicSquare.getTwoTwo());
    }

    public static void main(String[] args) {
        /*MagicSquare magicSquare = new MagicSquare(1, 1,2,3,4,5,6,7,8,9);
        Set<Integer> set = new HashSet<>();
        set.add(magicSquare.getZeroZero());
        set.add(magicSquare.getZeroOne());
        set.add(magicSquare.getZeroTwo());
        set.add(magicSquare.getOneZero());
        set.add(magicSquare.getOneOne());
        set.add(magicSquare.getOneTwo());
        set.add(magicSquare.getTwoZero());
        set.add(magicSquare.getTwoOne());
        set.add(magicSquare.getTwoTwo());
        if (set.size() == 9) {
            System.out.println("Все разные");
            System.out.println("========");
            System.out.print(magicSquare.getZeroZero());
            System.out.print(magicSquare.getZeroOne());
            System.out.print(magicSquare.getZeroTwo());
            System.out.println();
            System.out.print(magicSquare.getOneZero());
            System.out.print(magicSquare.getOneOne());
            System.out.print(magicSquare.getOneTwo());
            System.out.println();
            System.out.print(magicSquare.getTwoZero());
            System.out.print(magicSquare.getTwoOne());
            System.out.print(magicSquare.getTwoTwo());
        } else {
            System.out.println("Есть дубликаты");
            System.out.println("========");
            System.out.print(magicSquare.getZeroZero());
            System.out.print(magicSquare.getZeroOne());
            System.out.print(magicSquare.getZeroTwo());
            System.out.println();
            System.out.print(magicSquare.getOneZero());
            System.out.print(magicSquare.getOneOne());
            System.out.print(magicSquare.getOneTwo());
            System.out.println();
            System.out.print(magicSquare.getTwoZero());
            System.out.print(magicSquare.getTwoOne());
            System.out.print(magicSquare.getTwoTwo());
        }*/
    }
}
