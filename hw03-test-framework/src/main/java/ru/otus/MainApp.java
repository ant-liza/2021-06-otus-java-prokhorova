package ru.otus;

import ru.otus.tests.DemoTest;
import ru.otus.tests.DemoTest2;
import ru.otus.tests.DemoTest3;

public class MainApp {
    public static void main(String[] args) {
        TestRunner.run(DemoTest2.class);
        TestRunner.run(DemoTest.class);
        TestRunner.run(DemoTest3.class);
    }
}
