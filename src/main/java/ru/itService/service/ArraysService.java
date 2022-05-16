package ru.itService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itService.model.ArrayStrings;
import ru.itService.persistence.ArraysRepository;

import java.io.*;
import java.util.*;

@Service
public class ArraysService {

    private final ArraysRepository repository;

    public ArraysService(ArraysRepository repository) {
        this.repository = repository;
    }

    public void create(ArrayStrings arrayStrings) {
        repository.save(calculate(arrayStrings));
    }

    public Collection<ArrayStrings> findAll() {
        List<ArrayStrings> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Collection<ArrayStrings> findByCount(int count) {
        return repository.findByCount(count);
    }

    public void createAll(List<ArrayStrings> arrayStrings) {
        repository.saveAll(arrayStrings);
    }

    public ArrayStrings calculate(ArrayStrings arrayStrings) {
        String[] strings = arrayStrings.getString().split(" ");
        String[] subStrings = arrayStrings.getSubString().split(" ");
        /*String result = "";*/
        int count = 0;

        /*for (String numberS1 : subStrings) {
            for (String numberS2 : strings) {
                if (numberS2.contains(numberS1)) {
                    if (!result.contains(numberS1)) {
                        result = String.join(" ", result, numberS1);
                        count++;
                        break;
                    }
                }
            }
        }*/
        SortedSet<String> set = new TreeSet<>();
        for (String numberS1 : subStrings) {
            for (String numberS2 : strings) {
                if (numberS2.contains(numberS1)) {
                    set.add(numberS1);
                    count++;
                    break;
                }
            }
        }
        String result = String.join(" ", set);
        arrayStrings.setResults(result);
        arrayStrings.setCount(count);
        return arrayStrings;
    }

    public void exportInTxt(ArrayStrings arrayStrings) {
        try(PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("exportFromServer.txt", true)))) {
            out.println(System.lineSeparator());
            out.println("ЭКСПОРТ С СЕРВЕРА:");
            out.println("Подстроки: " + arrayStrings.getSubString());
            out.println("Строки: " + arrayStrings.getString());
            out.println("Тип задачи: " + arrayStrings.getTypeTask());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*TODO обработка при отправки пустоты*/
    public List<ArrayStrings> importFromTxt(MultipartFile file) {
        File condFile = new File(file.getOriginalFilename());
        List<ArrayStrings> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(condFile))) {
            String line = in.readLine();
            while (line != null) {
                ArrayStrings arrayStrings = new ArrayStrings();
                if (line.contains("Подстроки")) {
                    arrayStrings.setSubString(line.substring(10));//11
                    line = in.readLine();
                }
                if (line.contains("Строки")) {
                    arrayStrings.setString(line.substring(7));//8
                    line = in.readLine();
                }
                if (line.contains("Тип")) {
                    arrayStrings.setTypeTask(line.substring(11));//12
                }

                if (arrayStrings.getSubString() != null || arrayStrings.getString() != null) {
                    list.add(calculate(arrayStrings));
                }

                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*TODO удалить*/
    public static void main(String[] args) {
        int[][] myArr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(myArr.length);
        /*String[] arr = new String[] {"as", "12", "f", "a", "1",};
        List<String> list = List.of("as", "12", "f", "a", "1");

        //SortedSet<String> set = Set.of(arr);

        SortedSet<String> set = new TreeSet<>(Set.of(arr));
        String re = String.join(" ", set);
        //re = re.replaceAll("\\,|\\[|\\]|\\s", " ");

        for (var item : set) {
            System.out.println(item);
        }
        System.out.println("---");
        System.out.println(re);
        //"123 s fd 12 1 a";
        String subStr = "1 1 1 s";
        String type = "substring";*/


    }
}
