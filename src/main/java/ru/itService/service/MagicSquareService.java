package ru.itService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itService.model.MagicSquare;
import ru.itService.persistence.MagicSquareRepository;

import java.io.*;
import java.util.*;

@Service
public class MagicSquareService {

    private final MagicSquareRepository repository;

    public MagicSquareService(MagicSquareRepository repository) {
        this.repository = repository;
    }

    public void create(MagicSquare magicSquare) {
        repository.save(magicSquare);
    }

    public void createAll(List<MagicSquare> magicSquare) {
        repository.saveAll(magicSquare);
    }

    public List<MagicSquare> findAll() {
        List<MagicSquare> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
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

    /*TODO обработка при отправки пустоты*/
    public List<MagicSquare> importFromTxt(MultipartFile file) {
        File condFile = new File(file.getOriginalFilename());
        List<MagicSquare> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(condFile))) {
            String line = in.readLine();
            while (line != null) {
                MagicSquare magicSquare = new MagicSquare();
                if (line.contains("Row_1")) {
                    String dataInLine = line.substring(7);
                    String[] arrayOfDataInLine = dataInLine.split(" ");
                    for (int i = 0; i < arrayOfDataInLine.length; i++) {
                        switch (i) {
                            case 0 -> magicSquare.setZeroZero(Integer.parseInt(arrayOfDataInLine[0]));
                            case 1 -> magicSquare.setZeroOne(Integer.parseInt(arrayOfDataInLine[1]));
                            case 2 -> magicSquare.setZeroTwo(Integer.parseInt(arrayOfDataInLine[2]));
                        }
                    }
                    line = in.readLine();
                }
                if (line.contains("Row_2")) {
                    String dataInLine = line.substring(7);
                    String[] arrayOfDataInLine = dataInLine.split(" ");
                    for (int i = 0; i < arrayOfDataInLine.length; i++) {
                        switch (i) {
                            case 0 -> magicSquare.setOneZero(Integer.parseInt(arrayOfDataInLine[0]));
                            case 1 -> magicSquare.setOneOne(Integer.parseInt(arrayOfDataInLine[1]));
                            case 2 -> magicSquare.setOneTwo(Integer.parseInt(arrayOfDataInLine[2]));
                        }
                    }
                    line = in.readLine();
                }
                if (line.contains("Row_3")) {
                    String dataInLine = line.substring(7);
                    String[] arrayOfDataInLine = dataInLine.split(" ");
                    for (int i = 0; i < arrayOfDataInLine.length; i++) {
                        switch (i) {
                            case 0 -> magicSquare.setTwoZero(Integer.parseInt(arrayOfDataInLine[0]));
                            case 1 -> magicSquare.setTwoOne(Integer.parseInt(arrayOfDataInLine[1]));
                            case 2 -> magicSquare.setTwoTwo(Integer.parseInt(arrayOfDataInLine[2]));
                        }
                    }
                }
                if (!validateMagicSquare(magicSquare)) {
                    list.add(magicSquare);
                }

                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {

        /*File file = new File("./exportSquareFromServer.txt");
        var list = importFromTxt(file);
        for (var item : list) {
            System.out.println("========");
            System.out.print(item.getZeroZero());
            System.out.print(item.getZeroOne());
            System.out.print(item.getZeroTwo());
            System.out.println();
            System.out.print(item.getOneZero());
            System.out.print(item.getOneOne());
            System.out.print(item.getOneTwo());
            System.out.println();
            System.out.print(item.getTwoZero());
            System.out.print(item.getTwoOne());
            System.out.print(item.getTwoTwo());
            System.out.println();
        }*/
    }

    /*public void magicCalculate(MagicSquare magicSquare) {
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
