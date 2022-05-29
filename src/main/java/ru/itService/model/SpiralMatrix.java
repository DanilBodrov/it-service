package ru.itService.model;

public class SpiralMatrix {

    private int length;
    private int[][] matrix;

    public SpiralMatrix(int length, int[][] matrix) {
        this.length = length;
        this.matrix = matrix;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

}
