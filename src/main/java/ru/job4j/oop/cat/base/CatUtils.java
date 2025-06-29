package ru.job4j.oop.cat.base;

import java.util.concurrent.ThreadLocalRandom;

public class CatUtils {
    private static int count = 0;
    private static final String[] KITTEN_NAMES = {
            "Барсик", "Мурзик", "Васька", "Рыжик", "Пушок",
            "Снежок", "Черныш", "Тигра", "Луна", "Звезда"
    };

    public static Cat createKitten() {
        CatValidator validator = new CatValidator();
        int index = ThreadLocalRandom.current().
                nextInt(KITTEN_NAMES.length);
        count++;
        return new Cat(KITTEN_NAMES[index], 1, validator);
    }

    public static int getTotalCats() {
        return count;
    }
}
