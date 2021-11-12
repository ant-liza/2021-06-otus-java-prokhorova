package ru.otus.proxy;

import com.google.common.collect.Lists;
import ru.otus.TestLog;
import ru.otus.annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestLogInvocationHandler implements InvocationHandler {
    private final TestLog testLog;
    private final List<Method> logAnnotatedMethods = Lists.newArrayList();

    public TestLogInvocationHandler(TestLog testLog) {
        this.testLog = testLog;
        List<Class> testLogInterfaces = Arrays.stream(testLog.getClass().getInterfaces())
                .filter(i -> i == TestLog.class)
                .collect(Collectors.toList());
        if (!testLogInterfaces.isEmpty()) {
            Method[] declaredMethods = testLogInterfaces.get(0).getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(Log.class)) {
                    logAnnotatedMethods.add(method);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (logAnnotatedMethods.contains(method)) {
            System.out.printf("executed method:%s%n", method.getName());
            System.out.println("parameters:" + Arrays.stream(args).collect(Collectors.toList()));
        }
        return method.invoke(testLog, args);
    }

}
