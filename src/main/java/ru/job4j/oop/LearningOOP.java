package ru.job4j.oop;

public class LearningOOP {

    private int number;
    private int id;
    private String name;
    private String surname;

    public LearningOOP(int number, int id, String name, String surname) {
        this.number = number;
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public LearningOOP(int number) {
        this.number = number;
    }

    /*public LearningOOP(int number) {
        this.number = number;
    }*/

    public void printInfo() {
        System.out.println(number);
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.surname);
    }

    public static void main(String[] args) {
        LearningOOP a = new LearningOOP(11);
        a.printInfo();
    }
}

