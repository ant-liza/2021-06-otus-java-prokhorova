package ru.otus;

import ru.otus.annotations.Log;

public interface TestLog {
    @Log
    void calculation(int value);

    @Log
    void calculation(int a, int b);

    void calculation(int a, int b, int c);

    @Log
    void calculation(String a, int b, String c);
}
