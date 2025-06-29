package ru.job4j.oop;

public class Main {
    public static void main(String[] args) {
        Cat testCat1 = new Cat("Барсик", 5);
        Cat testCat2 = new Cat("Мурзик", 1);
        Cat testCat3 = new Cat("Мурзик", 6);

        testCat1.meet(testCat2);
        testCat2.meet(testCat3);

        testCat2.fight(testCat1);
        testCat2.fight(testCat2);

        int str = testCat2.getAge();
        System.out.println(str);
    }
}
