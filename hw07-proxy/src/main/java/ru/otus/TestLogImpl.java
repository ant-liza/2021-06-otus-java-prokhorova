package ru.otus;

public class TestLogImpl implements TestLog {
    @Override
    public void calculation(int value) {
        System.out.println("One parameter");
    }

    @Override
    public void calculation(int a, int b) {
        System.out.println("Two parameters");
    }

    @Override
    public void calculation(int a, int b, int c) {
        System.out.println("Three parameters");
    }

    @Override
    public void calculation(String a, int b, String c) {

    }
}
