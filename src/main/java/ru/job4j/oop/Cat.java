package ru.job4j.oop;

import java.text.MessageFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private String name;
    private int age;
    private static int count = 0;

    private static final String[] KITTEN_NAMES = {
            "Барсик", "Мурзик", "Васька", "Рыжик", "Пушок",
            "Снежок", "Черныш", "Тигра", "Луна", "Звезда"
    };

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isEmpty(name) || isNumeric(name)) {
            System.out.println("недопустимое имя!");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Возраст не может быть меньше нуля");
        } else if (age > 30) {
            System.out.println("Ваш кот не может быть таким старым");
        } else {
            this.age = age;
        }
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isAgeNotAllow(int age) {
        return age <= 0 || age > 30;
    }

    public static int getTotalCats() {
        return count;
    }

    public void meow() {
        System.out.println("Меня зовут " + this.name);
    }

    private String getAgeEnding(int age) {
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
    }

    /*public void haveBirthdayAndPrint() {
        this.age++;
        System.out.println("Теперь мне " + this.age + " " + getAgeEnding(this.age));
    }*/

    public void haveBirthday() {
        this.age++;
    }

    public void meet(Cat other) {
        String result = MessageFormat.format(
                "Я {0} и я встретил {1}а",
                this.name,
                other.name
        );
        System.out.println(result);
        if (this.name.equals(other.name)) {
            System.out.println("Ого! У нас одинаковые имена!");
        }
    }

    public void fight(Cat other) {
        if (other == null || this == other) {
            System.out.println("Не могу драться с этим котом!");
            return;
        }

        if (this.age > other.age) {
            applyAgeChange(this, 1);
            applyAgeChange(other, -1);
            printWinner(this);
        } else if (this.age < other.age) {
            applyAgeChange(this, -1);
            applyAgeChange(other, 1);
            printWinner(other);
        } else {
            System.out.println("Ничья!");
        }
    }

    private void applyAgeChange(Cat cat, int change) {
        int newAge = cat.age + change;
        if (!isAgeNotAllow(newAge)) {
            cat.age = newAge;
        }
    }

    private void printWinner(Cat winner) {
        System.out.printf("Я %s победил!%n", winner.name);
    }

    public static Cat createKitten() {
        int index = ThreadLocalRandom.current().nextInt(KITTEN_NAMES.length);
        return new Cat(KITTEN_NAMES[index], 1);
    }
}
