package ru.otus;

import ru.otus.annotations.Log;

public class TestLogImpl implements TestLog {
    @Log
    @Override
    public void calculation(int value) {
        System.out.println("One parameter");
    }

    @Log
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
