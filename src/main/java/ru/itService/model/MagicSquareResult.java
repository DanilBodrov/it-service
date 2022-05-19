package ru.itService.model;

import javax.persistence.*;

@Entity
@Table(name = "magic_square_result")
public class MagicSquareResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int zeroZero;
    private int zeroOne;
    private int zeroTwo;

    private int oneZero;
    private int oneOne;
    private int oneTwo;

    private int twoZero;
    private int twoOne;
    private int twoTwo;
    @ManyToOne
    @JoinColumn(name = "magic_square_id")
    private MagicSquare magicSquareId;

    public MagicSquareResult(/*int id,*/
                             int zeroZero,
                             int zeroOne,
                             int zeroTwo,
                             int oneZero,
                             int oneOne,
                             int oneTwo,
                             int twoZero,
                             int twoOne,
                             int twoTwo,
                             MagicSquare magicSquareId ) {
        /*this.id = id;*/
        this.zeroZero = zeroZero;
        this.zeroOne = zeroOne;
        this.zeroTwo = zeroTwo;
        this.oneZero = oneZero;
        this.oneOne = oneOne;
        this.oneTwo = oneTwo;
        this.twoZero = twoZero;
        this.twoOne = twoOne;
        this.twoTwo = twoTwo;
        this.magicSquareId = magicSquareId;
    }

    public MagicSquareResult() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZeroZero() {
        return zeroZero;
    }

    public void setZeroZero(int zeroZero) {
        this.zeroZero = zeroZero;
    }

    public int getZeroOne() {
        return zeroOne;
    }

    public void setZeroOne(int zeroOne) {
        this.zeroOne = zeroOne;
    }

    public int getZeroTwo() {
        return zeroTwo;
    }

    public void setZeroTwo(int zeroTwo) {
        this.zeroTwo = zeroTwo;
    }

    public int getOneZero() {
        return oneZero;
    }

    public void setOneZero(int oneZero) {
        this.oneZero = oneZero;
    }

    public int getOneOne() {
        return oneOne;
    }

    public void setOneOne(int oneOne) {
        this.oneOne = oneOne;
    }

    public int getOneTwo() {
        return oneTwo;
    }

    public void setOneTwo(int oneTwo) {
        this.oneTwo = oneTwo;
    }

    public int getTwoZero() {
        return twoZero;
    }

    public void setTwoZero(int twoZero) {
        this.twoZero = twoZero;
    }

    public int getTwoOne() {
        return twoOne;
    }

    public void setTwoOne(int twoOne) {
        this.twoOne = twoOne;
    }

    public int getTwoTwo() {
        return twoTwo;
    }

    public void setTwoTwo(int twoTwo) {
        this.twoTwo = twoTwo;
    }

    public MagicSquare getMagicSquareId() {
        return magicSquareId;
    }

    public void setMagicSquareId(MagicSquare magicSquareId) {
        this.magicSquareId = magicSquareId;
    }
}
