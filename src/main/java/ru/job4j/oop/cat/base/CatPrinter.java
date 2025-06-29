package ru.job4j.oop.cat.base;

import java.text.MessageFormat;

/**
 * Класс для цветного вывода информации о котах в консоль.
 * Поддерживает русский и английский языки, а также настройку цвета текста.
 * <p>
 * Пример использования:
 * <pre>
 * CatPrinter printer = new CatPrinter("\u001B[31m"); // Красный текст
 * printer.printCatInfo(cat);
 * </pre>
 *
 * @see Cat
 * @see CatUtils
 */
public class CatPrinter {
    /**
     * ANSI-код цвета текста для вывода в консоль.
     * Например:
     * - Красный: "\u001B[31m"
     * - Синий: "\033[1;34m"
     * <p>
     * Сброс цвета осуществляется добавлением "\033[0m".
     */
    private String textColor;

    /**
     * Создает принтер с заданным цветом текста.
     *
     * @param textColor ANSI-код цвета (например, "\u001B[31m" для красного).
     * @throws NullPointerException если textColor == null.
     */
    public CatPrinter(String textColor) {
        this.textColor = textColor;
    }

    /**
     * Выводит информацию о коте в консоль с учетом языка и заданного цвета.
     * Формат вывода:
     * - Для русского: "Кот по кличке {имя}, возраст {возраст} {год/года/лет}"
     * - Для английского: "Cat {name}, age {age} {year/years}"
     * <p>
     * Цвет сбрасывается автоматически после вывода.
     *
     * @param cat Объект кота для печати (не может быть null).
     * @throws NullPointerException если cat == null.
     */
    public void printCatInfo(Cat cat) {
        String name = cat.getName();
        int age = cat.getAge();
        String lang = cat.getLang();

        String str = "";
        String ending = CatUtils.getAgeEnding(age, lang);

        if (lang.equals("ru")) {
            str = MessageFormat.format(
                    "Кот по кличке {0}, "
                            + "возраст {1}  "
                            + "{2}", name, age, ending);
        }

        if (lang.equals("en")) {
            str = MessageFormat.format(
                    "Cat {0}, "
                            + "age {1}  "
                            + "{2}", name, age, ending);
        }
        System.out.println(textColor + str + "\033[0m");
    }

    public static void main(String[] args) {
        CatValidator validator = new CatValidator();
        CatPrinter redPrinter = new CatPrinter("\u001B[31m");
        CatPrinter bluePrinter = new CatPrinter("\033[1;34m");
        Cat cat = new Cat("Барсик", 3, "ru", validator);
        Cat boy = new Cat("boy", 5, "en", validator);

        redPrinter.printCatInfo(cat);
        bluePrinter.printCatInfo(boy);
        System.out.println("конец задачи");
    }
}
