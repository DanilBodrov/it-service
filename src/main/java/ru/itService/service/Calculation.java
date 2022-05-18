package ru.itService.service;

import java.util.*;

public class Calculation {
    public static void main(String[] args) {
        int[][] myArr = {{4, 3, 1}, {2, 5, 6}, {7, 8, 9}};
        see(calculationMagicSquare(myArr));
    }

    public static int[][] calculationMagicSquare(int[][] myArray) {
        see(myArray); // вывод изначального
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
        return myArray;
    }

    public static void see(int[][] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                System.out.print(myArr[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------");
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
