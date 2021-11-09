package ru.otus.proxy;

import ru.otus.TestLog;
import ru.otus.annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestLogInvocationHandler implements InvocationHandler {
    private final TestLog testLog;

    public TestLogInvocationHandler(TestLog testLog) {
        this.testLog = testLog;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Log.class)) {
            System.out.printf("executed method:%s%n", method.getName());
            System.out.println("parameters:" + Arrays.stream(args).collect(Collectors.toList()));
        }
        return method.invoke(testLog, args);
    }

}
