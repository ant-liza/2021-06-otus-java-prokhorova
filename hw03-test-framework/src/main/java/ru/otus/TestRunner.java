package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestRunner {
    private static int countOfTests;
    private static int countOfUnSuccessfulTests;

    /**
     * Для каждого метода с аннотацией Test создаем экземпляр тестового класса
     */

    public static void run(Class<?> clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(declaredTestMethod -> declaredTestMethod.isAnnotationPresent(Test.class))
                .forEach(testMethod -> {
                    countOfTests++;
                    Test testAnnotation = testMethod.getAnnotation(Test.class);
                    System.out.printf("%n---START Test: %s(%s)%n", testMethod.getName(), testAnnotation.name());
                    Object instanceOfClazz = ReflectionHelper.instantiate(clazz);
                    runMethodsByAnnotation(declaredMethods, Before.class, instanceOfClazz);
                    try {
                        ReflectionHelper.callMethod(instanceOfClazz, testMethod.getName());
                    } catch (Exception e) {
                        countOfUnSuccessfulTests++;
                        printInfoInException(testMethod, e);
                    }
                    runMethodsByAnnotation(declaredMethods, After.class, instanceOfClazz);
                    System.out.printf("---END %s%n", testMethod.getName());
                });
        printStatistics();
    }

    private static void runMethodsByAnnotation(Method[] declaredMethods,
                                               Class<? extends Annotation> annotation,
                                               Object instanceOfClass) {
        Arrays.stream(declaredMethods)
                .filter(method -> method.isAnnotationPresent(annotation))
                .forEach(m -> {
                    try {
                        ReflectionHelper.callMethod(instanceOfClass, m.getName());
                    } catch (Exception e) {
                        printInfoInException(m, e);
                    }
                });
    }

    public static String getTestNameInAnnotation(Annotation annotation) {
        String valueOfName;
        Test testAnnotation = (Test) annotation;
        valueOfName = testAnnotation.name();
        return valueOfName;
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
        System.out.printf("%nCount of Unsuccessful tests = %d", countOfUnSuccessfulTests);
        System.out.printf("%nCount of Successful tests = %d", countOfTests - countOfUnSuccessfulTests);
    }
}
