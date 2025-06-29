package ru.job4j.oop.cat.base;

import java.text.MessageFormat;

public class CatActions {
    private final Cat cat;

    public CatActions(Cat cat) {
        this.cat = cat;
    }

    public void meow() {
        System.out.printf("Меня зовут %s", cat.getName());
    }

    public void haveBirthdayAndPrint(boolean print) {
        cat.setAge((cat.getAge() + 1));

        if (print) {
            System.out.printf("Теперь мне %d %s%n",
                    cat.getAge(),
                    CatUtils.getAgeEnding(cat.getAge(), cat.getLang()));
        }
    }

    /*public String getAgeEnding(int age) {
        int tens = age / 10;
        int units = age % 10;
        String ageEnd = "год";
        if ((tens == 0 || tens >= 2) && units == 1) {
            ageEnd = "год";
        } else if ((tens == 0 || tens >= 2) && (units >= 2 && units < 5)) {
            ageEnd = "года";
        } else {
            ageEnd = "лет";
        }
        return ageEnd;
    }*/

    public void fight(Cat opponent) {

        if (cat == opponent) {
            System.out.println("Не могу драться с самим собой!");
            return;
        }

        if (cat.getAge() > opponent.getAge()) {
            applyAgeChange(cat, 1);
            applyAgeChange(opponent, -1);
            printWinner(cat);
        } else if (cat.getAge() < opponent.getAge()) {
            applyAgeChange(cat, -1);
            applyAgeChange(opponent, 1);
            printWinner(opponent);
        } else {
            System.out.println("Ничья!");
        }
    }

    private void applyAgeChange(Cat cat, int change) {
        int newAge = cat.getAge() + change;
        if (cat.getValidator().validateAge(newAge)) {
            cat.setAge(newAge);
        }
    }

    private void printWinner(Cat winner) {
        System.out.printf("Я %s победил!%n", winner.getName());
    }

    public void meet(Cat other) {
        String result = MessageFormat.format(
                "Я {0} и я встретил {1}а",
                cat.getName(),
                other.getName()
        );
        System.out.println(result);
        if (cat.getName().equals(other.getName())) {
            System.out.println("Ого! У нас одинаковые имена!");
        }
    }
}
