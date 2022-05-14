package ru.itService.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "arrays")
public class ArrayStrings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String string;
    private String subString;
    private String results;
    private String typeTask = "substring";
    private int count;

    public ArrayStrings(int id, String string, String subString, String results, String typeTask, int count) {
        this.id = id;
        this.string = string;
        this.subString = subString;
        this.results = results;
        this.typeTask = typeTask;
        this.count = count;
    }

    public ArrayStrings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getSubString() {
        return subString;
    }

    public void setSubString(String subString) {
        this.subString = subString;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStrings that = (ArrayStrings) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
