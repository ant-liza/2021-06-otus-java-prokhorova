package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    private static int countOfTests;
    private static int unsuccessfulTests;
    private static final List<String> skippedTests = new ArrayList<>();

    /**
     * Для каждого метода с аннотацией Test создаем экземпляр тестового класса
     */

    public static void run(Class<?> clazz) {
        System.out.print("\n*********" + clazz.getSimpleName() + "***********");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        List<Method> beforeMethods = getMethodsByAnnotation(declaredMethods, Before.class);
        List<Method> testMethods = getMethodsByAnnotation(declaredMethods, Test.class);
        List<Method> afterMethods = getMethodsByAnnotation(declaredMethods, After.class);
        countOfTests = testMethods.size();
        for (Method testMethod : testMethods) {
            Test testAnnotation = testMethod.getAnnotation(Test.class);
            System.out.printf("%n---START Test: %s(%s)%n", testMethod.getName(), testAnnotation.name());
            Object instanceOfClazz = ReflectionHelper.instantiate(clazz);
            try {
                runMethods(beforeMethods, instanceOfClazz);
            } catch (Exception e) {
                System.out.println("@Before method has error. Skip Test");
                skippedTests.add(testMethod.getName());
                continue;
            }
            try {
                ReflectionHelper.callMethod(instanceOfClazz, testMethod.getName());
            } catch (Exception e) {
                printInfoInException(testMethod, e);
                unsuccessfulTests++;
            }
            runMethods(afterMethods, instanceOfClazz);
            System.out.printf("---END %s%n", testMethod.getName());
        }
        printStatistics();
        skippedTests.clear();
    }

    private static void runMethods(List<Method> listOfMethods,
                                   Object instanceOfClass) {
        for (Method method : listOfMethods) {
            ReflectionHelper.callMethod(instanceOfClass, method.getName());
        }
    }

    private static List<Method> getMethodsByAnnotation(Method[] declaredMethods,
                                                       Class<? extends Annotation> annotation) {
        List<Method> listOfMethods = new ArrayList<>();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(annotation)) {
                listOfMethods.add(method);
            }
        }
        return listOfMethods;
    }

    private static void printInfoInException(Method method, Exception e) {
        System.out.printf("exception in method: %s%n", method.getName());
        System.out.printf("exception message: %s%n", ((InvocationTargetException) e.getCause()).getTargetException().getMessage());
    }

    private static void printStatistics() {
        System.out.println("\n___________");
        System.out.println("Statistics:");
        System.out.println("___________");
        System.out.printf("Count of tests = %d", countOfTests);
        System.out.printf("%nCount of Unsuccessful tests = %d", unsuccessfulTests);
        System.out.printf("%nCount of Skipped tests = %d", skippedTests.size());
        System.out.printf("%nSkipped tests names = %s", skippedTests);
        System.out.printf("%nCount of Successful tests = %d", countOfTests - unsuccessfulTests - skippedTests.size());
    }
}
