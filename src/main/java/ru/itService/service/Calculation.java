package ru.itService.service;

import ru.itService.model.MagicSquare;
import ru.itService.model.MagicSquareResult;

import java.util.*;

public class Calculation {

    public static MagicSquareResult calculationMagicSquare(MagicSquare magicSquare) {
        int[][] myArray = conversion(magicSquare);
        int n = myArray.length;
        int numberNow = 1;
        List<Integer> listStand = new ArrayList<>();
        int rowOld = 0;
        int colOld = 0;
        int rowNow;
        int colNow;
        int replaceNumber;

        while (!checkSquare(myArray)) {
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    if (myArray[i][j] == 1 && numberNow == 1) {
                        replaceNumber = myArray[0][1];
                        myArray[0][1] = 1;
                        myArray[i][j] = replaceNumber;
                        colOld = 0;
                        rowOld = 1;
                        listStand.add(1);
                        numberNow++;
                    } else if (myArray[i][j] == numberNow) {
                        if (colOld - 1 < 0) {
                            colNow = n - 1;
                        } else {
                            colNow = colOld - 1;
                        }
                        if (rowOld + 1 == 3) {
                            rowNow = n - 3;
                        } else {
                            rowNow = rowOld +1;
                        }
                        if (listStand.contains(myArray[colNow][rowNow])) {
                            replaceNumber = myArray[colOld + 1][rowOld];
                            myArray[colOld + 1][rowOld] = numberNow;
                            myArray[i][j] = replaceNumber;
                            colOld = colOld + 1;
                        } else {
                            replaceNumber = myArray[colNow][rowNow];
                            myArray[colNow][rowNow] = numberNow;
                            myArray[i][j] = replaceNumber;
                            rowOld = rowNow;
                            colOld = colNow;
                        }
                        listStand.add(numberNow);
                        numberNow++;
                    }
                }
            }
        }
        return conversion(myArray, magicSquare);
    }

    public static int[][] conversion(MagicSquare magicSquare) {
        return new int[][]{
               {
                       magicSquare.getZeroZero(),
                       magicSquare.getZeroOne(),
                       magicSquare.getZeroTwo()
               },
               {
                       magicSquare.getOneZero(),
                       magicSquare.getOneOne(),
                       magicSquare.getOneTwo()
               },
               {
                       magicSquare.getTwoZero(),
                       magicSquare.getTwoOne(),
                       magicSquare.getTwoTwo()
               }
       };
    }
    public static MagicSquareResult  conversion(int[][] myArray, MagicSquare magicSquare) {
        return new MagicSquareResult(
                myArray[0][0],
                myArray[0][1],
                myArray[0][2],
                myArray[1][0],
                myArray[1][1],
                myArray[1][2],
                myArray[2][0],
                myArray[2][1],
                myArray[2][2],
                magicSquare
        );
    }

    public static boolean checkSquare(int[][] arr) {
        boolean res = false;
        int line1 = arr[0][0] + arr[0][1] + arr[0][2];
        int line2 = arr[1][0] + arr[1][1] + arr[1][2];
        int line3 = arr[2][0] + arr[2][1] + arr[2][2];

        int col1 = arr[0][0] + arr[1][0] + arr[2][0];
        int col2 = arr[0][1] + arr[1][1] + arr[2][1];
        int col3 = arr[0][2] + arr[1][2] + arr[2][2];
        if (line1 == line2 && line2 == line3 && col1 == col2 && col2 == col3 && line3 == col3) {
            res = true;
        }
        return res;
    }
}
