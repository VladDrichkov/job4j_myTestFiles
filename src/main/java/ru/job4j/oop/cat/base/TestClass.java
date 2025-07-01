package ru.job4j.oop.cat.base;

public class TestClass {

    /**
     * Нельзя в нестатическом методе использовать
     * поля и методы нестатического класса
     *
     * если нужно использовать, нужно либо
     * - создать объект этого класса и относительно него использовать
     * нестатический метод
     * - либо передать его в качестве параметра в метод
     */
    private static final int I = 2;
    private String testField = "testField";

    public TestClass(String testField) {
        this.testField = testField;
    }

    public static void testMethod(TestClass testClassObject) {
        System.out.println("Это тестовый метод");
        final int I = 2;

        CatUtils.createKitten();
        //String str = this.testField; // ошибка !
        //nonStaticMethod(); // ошибка
        Cat testCAt = new Cat("test", 1, "en", new CatValidator());
        CatActions catAct = new CatActions(testCAt);
        catAct.meow(); // создали объект и использовали метод
        //this.testField = ""; // невозможно обратиться к полю класса
        TestClass t = new TestClass("str");
        t.nonStaticMethod(); // создали объект и использовали метод
        testClassObject.nonStaticMethod(); // передали в статический метод
        // объект класса и относительно него используем нестатический метод
    }

    private void nonStaticMethod() {
    }

    private static class TestClass1 {

    }

}
