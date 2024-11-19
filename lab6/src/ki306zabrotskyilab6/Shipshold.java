package ki306zabrotskyilab6;

import java.util.*;
import java.io.*;

/**
 * Interface 
 */
interface Data extends Comparable<Data> {
    public int getSize();
    public void print();
}

class ShipsHold <T extends Data> {

    private ArrayList<T> arr;

    ShipsHold(){
        arr = new ArrayList<T>();
    }

    public T findMax() {
        if (!arr.isEmpty()) {
            T max = arr.get(0);
            for (int i=1; i< arr.size(); i++) {
                if ( arr.get(i).compareTo(max) > 0 )
                max = arr.get(i);
            }
            return max;
        }
        return null;
    }

    public void AddData(T data) {
        arr.add(data);
        System.out.print("Element added: ");
        data.print();
    }

    public void DeleteData(int i) {
        arr.remove(i);
    }
}

class Container implements Data {

    private String containerName;
    private int size;

    public Container(String pName, int pSize) {
        containerName = pName;
        size = pSize;
    }

    public String getContainer() {
        return containerName;
    }

    public void setContainer(String name) {
        containerName = name;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Контейнер: " + containerName + ", розмір контейнеру: " + size + ";\n");
    }
}

class Car implements Data {

    private String carName;
    private String type;
    private int size;

    public Car(String pName, String pType, int pSize) {
        carName = pName;
        pType = pType;
        size = pSize;
    }

    public String getCar() {
        return carName;
    }

    public void setCar(String name) {
        carName = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        type = Type;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Машина: " + carName + ", тип: " + type + ", розмір машини: " + size + ";\n");
    }
}

class Barrel implements Data {

    private String barrelName;
    private int size;

    public Barrel(String pName, int pSize) {
        barrelName = pName;
        size = pSize;
    }

    public String getBarrel() {
        return barrelName;
    }

    public void setBarrel(String name) {
        barrelName = name;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Бочка: " + barrelName + ", розмір бочки: " + size + ";\n");
    }
}