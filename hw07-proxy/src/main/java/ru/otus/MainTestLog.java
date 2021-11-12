package ru.otus;

import ru.otus.proxy.TestLogInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainTestLog {

    public static void main(String args[]) {
        InvocationHandler handler = new TestLogInvocationHandler(new TestLogImpl());
        TestLog testLog = (TestLog) Proxy.newProxyInstance(TestLog.class.getClassLoader(),
                new Class<?>[]{TestLog.class}, handler);
        testLog.calculation(8 );
        testLog.calculation(15, 25);
        testLog.calculation(1, 2, 3);
        testLog.calculation("fdg", 2, "rurir");
    }
}
