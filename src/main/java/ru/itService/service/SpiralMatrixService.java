package ru.itService.service;

import org.springframework.stereotype.Service;
import ru.itService.model.SpiralMatrix;

@Service
public class SpiralMatrixService {

    public SpiralMatrix calculationSpiralMatrix(int matrixLength) {
        int number = 1;
        int[][] array = new int[matrixLength][matrixLength];
        int n = 0;
        int m = matrixLength - 1;
        int h = 1;
        int y = 1;
        while (number < (matrixLength * matrixLength)) {
            /*TODO слева направо*/
            for (int j = n; j < matrixLength - h; j++) {
                array[n][j] = number++;
            }

            /*TODO сверху вниз*/
            for (int j = n; j < matrixLength - h; j++) {
                int i = m;
                array[j][i] = number++;
            }

            /*TODO справа налево*/
            for (int j = matrixLength - h; j >= y; j--) {
                int i = m;
                array[i][j] = number++;
            }

            /*TODO снизу вверх*/
            for (int j = matrixLength - h; j > n; j--) {
                int i = n;
                array[j][i] = number++;
            }
            h++;
            n++;
            m--;
            y++;
        }

        if(matrixLength % 2 == 1) {
            array[matrixLength/2][matrixLength/2] = (matrixLength * matrixLength);
        }

        return new SpiralMatrix(matrixLength, array);
    }
}
