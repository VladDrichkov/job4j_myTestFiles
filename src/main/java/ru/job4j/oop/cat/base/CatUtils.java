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
        return new Cat(KITTEN_NAMES[index], 1, "ru", validator);
    } //TODO добавить использование en кота

    public static int getTotalCats() {
        return count;
    }

    public static String getAgeEnding(int age, String lang) {

        int tens = age / 10;
        int units = age % 10;
        String ageEnd = "год";

        if (lang.equals("ru")) {
            if ((tens == 0 || tens >= 2) && units == 1) {
                ageEnd = "год";
            } else if ((tens == 0 || tens >= 2) && (units >= 2 && units < 5)) {
                ageEnd = "года";
            } else {
                ageEnd = "лет";
            }
        }
        if (lang.equals("en")) {
            ageEnd = (age == 1) ? "year" : "years"; // Английский вариант
        }
        return ageEnd;
    }
}
