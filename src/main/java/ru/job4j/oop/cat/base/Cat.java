package ru.job4j.oop.cat.base;

public class Cat {
    private String name;
    private int age;
    private final CatValidator validator;  // Храним валидатор как поле

    // Конструктор требует передать валидатор
    public Cat(String name, int age, CatValidator validator) {
        this.validator = validator;  // Сохраняем валидатор в поле
        setName(name);  // Используем сеттер для валидации
        setAge(age);
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени (использует validator из поля)
    public void setName(String name) {
        if (validator.validateName(name)) {  // Проверяем через validator
            this.name = name;
        } else {
            this.name = "Безымянный";  // Значение по умолчанию
        }
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Сеттер для возраста (использует validator из поля)
    public void setAge(int age) {
        if (validator.validateAge(age)) {  // Проверяем через validator
            this.age = age;
        } else {
            this.age = 1;  // Значение по умолчанию
        }
    }

    public CatValidator getValidator() {
        return validator;
    }

    // Красивый вывод информации о коте

    @Override
    public String toString() {
        return String.format("Кот: имя='%s', возраст=%d", name, age);
    }
}